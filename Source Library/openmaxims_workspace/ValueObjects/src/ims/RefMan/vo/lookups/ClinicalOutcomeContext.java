// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class ClinicalOutcomeContext extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public ClinicalOutcomeContext()
	{
		super();
	}
	public ClinicalOutcomeContext(int id)
	{
		super(id, "", true);
	}
	public ClinicalOutcomeContext(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public ClinicalOutcomeContext(int id, String text, boolean active, ClinicalOutcomeContext parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public ClinicalOutcomeContext(int id, String text, boolean active, ClinicalOutcomeContext parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public ClinicalOutcomeContext(int id, String text, boolean active, ClinicalOutcomeContext parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static ClinicalOutcomeContext buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new ClinicalOutcomeContext(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (ClinicalOutcomeContext)super.getParentInstance();
	}
	public ClinicalOutcomeContext getParent()
	{
		return (ClinicalOutcomeContext)super.getParentInstance();
	}
	public void setParent(ClinicalOutcomeContext parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		ClinicalOutcomeContext[] typedChildren = new ClinicalOutcomeContext[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (ClinicalOutcomeContext)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof ClinicalOutcomeContext)
		{
			super.addChild((ClinicalOutcomeContext)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof ClinicalOutcomeContext)
		{
			super.removeChild((ClinicalOutcomeContext)child);
		}
		return super.getChildInstances().size();
	}
	public Image getExpandedImage()
	{
		return super.getImage();
	}
	public Image getCollapsedImage()
	{
		return super.getImage();
	}
	public static ims.framework.IItemCollection getNegativeInstancesAsIItemCollection()
	{
		ClinicalOutcomeContextCollection result = new ClinicalOutcomeContextCollection();
		return result;
	}
	public static ClinicalOutcomeContext[] getNegativeInstances()
	{
		return new ClinicalOutcomeContext[] {};
	}
	public static String[] getNegativeInstanceNames()
	{
		return new String[] {};
	}
	public static ClinicalOutcomeContext getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		// No negative instances found
		return null;
	}
	public static ClinicalOutcomeContext getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		// No negative instances found
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1341030;
}
