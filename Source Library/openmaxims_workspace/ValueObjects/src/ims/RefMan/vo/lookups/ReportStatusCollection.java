// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.lookups;

import ims.framework.cn.data.TreeModel;
import ims.framework.cn.data.TreeNode;
import ims.vo.LookupInstanceCollection;
import ims.vo.LookupInstVo;

public class ReportStatusCollection extends LookupInstanceCollection implements ims.vo.ImsCloneable, TreeModel
{
	private static final long serialVersionUID = 1L;
	public void add(ReportStatus value)
	{
		super.add(value);
	}
	public int indexOf(ReportStatus instance)
	{
		return super.indexOf(instance);
	}
	public boolean contains(ReportStatus instance)
	{
		return indexOf(instance) >= 0;
	}
	public ReportStatus get(int index)
	{
		return (ReportStatus)super.getIndex(index);
	}
	public void remove(ReportStatus instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public Object clone()
	{
		ReportStatusCollection newCol = new ReportStatusCollection();
		ReportStatus item;
		for (int i = 0; i < super.size(); i++)
		{
			item = this.get(i);
			newCol.add(new ReportStatus(item.getID(), item.getText(), item.isActive(), item.getParent(), item.getImage(), item.getColor(), item.getOrder()));
		}
		for (int i = 0; i < newCol.size(); i++)
		{
			item = newCol.get(i);
			if (item.getParent() != null)
			{
				int parentIndex = this.indexOf(item.getParent());
				if(parentIndex >= 0)
					item.setParent(newCol.get(parentIndex));
				else
					item.setParent((ReportStatus)item.getParent().clone());
			}
		}
		return newCol;
	}
	public ReportStatus getInstance(int instanceId)
	{
		return (ReportStatus)super.getInstanceById(instanceId);
	}
	public TreeNode[] getRootNodes()
	{
		LookupInstVo[] roots = super.getRoots();
		TreeNode[] nodes = new TreeNode[roots.length];
		System.arraycopy(roots, 0, nodes, 0, roots.length);
		return nodes;
	}
	public ReportStatus[] toArray()
	{
		ReportStatus[] arr = new ReportStatus[this.size()];
		super.toArray(arr);
		return arr;
	}
	public static ReportStatusCollection buildFromBeanCollection(java.util.Collection beans)
	{
		ReportStatusCollection coll = new ReportStatusCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while(iter.hasNext())
		{
			coll.add(ReportStatus.buildLookup((ims.vo.LookupInstanceBean)iter.next()));
		}
		return coll;
	}
	public static ReportStatusCollection buildFromBeanCollection(ims.vo.LookupInstanceBean[] beans)
	{
		ReportStatusCollection coll = new ReportStatusCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(ReportStatus.buildLookup(beans[x]));
		}
		return coll;
	}
}
