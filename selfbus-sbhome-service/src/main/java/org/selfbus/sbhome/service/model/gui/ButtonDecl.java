package org.selfbus.sbhome.service.model.gui;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.selfbus.sbhome.service.model.base.Namespaces;

/**
 * A button.
 */
@XmlType(name = "button", namespace = Namespaces.PROJECT)
@XmlAccessorType(XmlAccessType.FIELD)
public class ButtonDecl extends LabelDecl
{
}
