//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.19 at 01:45:30 PM GMT+01:00 
//

package org.selfbus.sbhome.service.model.action;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import org.selfbus.sbhome.service.model.base.Namespaces;

/**
 * An action that changes the appearance and/or contents of a GUI element.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = Namespaces.PROJECT)
public class ChangeItemActionDecl extends AbstractActionDecl
{
   @XmlAttribute(name = "label")
   protected String label;

   @XmlAttribute(name = "icon")
   protected String icon;

   /**
    * Gets the value of the label property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getLabel()
   {
      return label;
   }

   /**
    * Sets the value of the label property.
    * 
    * @param value allowed object is {@link String }
    * 
    */
   public void setLabel(String value)
   {
      this.label = value;
   }

   /**
    * Gets the value of the icon property.
    * 
    * @return possible object is {@link String }
    * 
    */
   public String getIcon()
   {
      return icon;
   }

   /**
    * Sets the value of the icon property.
    * 
    * @param value allowed object is {@link String }
    * 
    */
   public void setIcon(String value)
   {
      this.icon = value;
   }
}
