package org.selfbus.sbhome.service.model.module;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.selfbus.sbhome.service.model.base.Namespaces;
import org.selfbus.sbhome.service.model.variable.VariableDeclaration;

/**
 * An output connector for model types.
 */
@XmlType(namespace = Namespaces.PROJECT)
@XmlAccessorType(XmlAccessType.FIELD)
public class ModuleTypeOutputConnector extends VariableDeclaration
{
}
