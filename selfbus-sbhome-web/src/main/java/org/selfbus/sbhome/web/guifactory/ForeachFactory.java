package org.selfbus.sbhome.web.guifactory;

import java.util.List;
import java.util.Vector;

import org.selfbus.sbhome.service.misc.SortUtils;
import org.selfbus.sbhome.service.model.Category;
import org.selfbus.sbhome.service.model.Item;
import org.selfbus.sbhome.service.model.Project;
import org.selfbus.sbhome.service.model.Room;
import org.selfbus.sbhome.service.model.gui.AbstractComponentDecl;
import org.selfbus.sbhome.service.model.gui.generator.Foreach;
import org.selfbus.sbhome.service.model.variable.GroupVariable;
import org.selfbus.sbhome.service.model.variable.Variable;
import org.selfbus.sbhome.service.process.Context;

/**
 * A component creator that creates elements for a {@link Foreach} declaration.
 */
public class ForeachFactory
{
   private final Project project;
   private final ComponentFactory compFactory;

   /**
    * Create a component creator that creates elements for a {@link Foreach} declaration.
    * 
    * @param project - the project
    * @param compFactory - the component factory
    */
   public ForeachFactory(Project project, ComponentFactory compFactory)
   {
      this.project = project;
      this.compFactory = compFactory;
   }

   /**
    * Process a {@link Foreach} declaration.
    * 
    * @param ctx - the context
    * @param decl - the {@link Foreach} declaration
    * @param proc - the processor to call with each created component
    */
   public void createElements(Context ctx, Foreach decl, ComponentProcessor proc)
   {
      String varName = decl.getVar();
      String type = decl.getItems();
      List<AbstractComponentDecl> childs = decl.getChilds();

      if ("rooms".equals(type))
      {
         for (Room room : SortUtils.sortByLabel(project.getRooms()))
         {
            Context childCtx = new Context(ctx);
            childCtx.set(varName, room);

            for (AbstractComponentDecl child : childs)
               compFactory.createComponent(childCtx, child, proc);
         }
      }
      else if ("categories".equals(type))
      {
         for (Category category : SortUtils.sortByLabel(project.getCategories()))
         {
            Context childCtx = new Context(ctx);
            childCtx.set(varName, category);

            for (AbstractComponentDecl child : childs)
               compFactory.createComponent(childCtx, child, proc);
         }
      }
      else if ("items".equals(type)) // all items of a room or category
      {
         final Room parentRoom = (Room) ctx.get("room");
         final Category parentCategory = (Category) ctx.get("category");

         List<Room> rooms;
         if (parentRoom != null)
         {
            rooms = new Vector<Room>(1);
            rooms.add(parentRoom);
         }
         else rooms = SortUtils.sortByLabel(project.getRooms());

         for (Room room : rooms)
         {
            for (Item item : SortUtils.sortByLabel(room.getItems()))
            {
               Context itemCtx = new Context(ctx);
               itemCtx.set(varName, item);
               itemCtx.set("room", room);

               if (parentCategory == null)
               {
                  for (AbstractComponentDecl child : childs)
                     compFactory.createComponent(itemCtx, child, proc);
               }
               else
               {
                  String itemName = item.getVariable();

                  Variable var = project.getVariable(itemName);
                  if (var instanceof GroupVariable && parentCategory.equals(((GroupVariable) var).getCategory()))
                  {
                     for (AbstractComponentDecl child : childs)
                        compFactory.createComponent(itemCtx, child, proc);
                  }
               }
            }
         }
      }
      else if ("groups".equals(type))
      {
         for (Variable group : project.getVariables())
         {
            Context childCtx = new Context(ctx);
            childCtx.set("group", group);

            for (AbstractComponentDecl child : childs)
               compFactory.createComponent(childCtx, child, proc);
         }
      }
      else
      {
         throw new RuntimeException("Invalid foreach item type: " + type);
      }
   }
}
