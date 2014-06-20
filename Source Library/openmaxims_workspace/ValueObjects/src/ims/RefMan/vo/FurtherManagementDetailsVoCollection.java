// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to RefMan.FurtherManagement business object (ID: 1096100018).
 */
public class FurtherManagementDetailsVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<FurtherManagementDetailsVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<FurtherManagementDetailsVo> col = new ArrayList<FurtherManagementDetailsVo>();
	public String getBoClassName()
	{
		return "ims.RefMan.domain.objects.FurtherManagement";
	}
	public boolean add(FurtherManagementDetailsVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, FurtherManagementDetailsVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			this.col.add(index, value);
			return true;
		}
		return false;
	}
	public void clear()
	{
		this.col.clear();
	}
	public void remove(int index)
	{
		this.col.remove(index);
	}
	public int size()
	{
		return this.col.size();
	}
	public int indexOf(FurtherManagementDetailsVo instance)
	{
		return col.indexOf(instance);
	}
	public FurtherManagementDetailsVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, FurtherManagementDetailsVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(FurtherManagementDetailsVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(FurtherManagementDetailsVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		FurtherManagementDetailsVoCollection clone = new FurtherManagementDetailsVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((FurtherManagementDetailsVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		
		return clone;
	}
	public boolean isValidated()
	{
		for(int x = 0; x < col.size(); x++)
			if(!this.col.get(x).isValidated())
				return false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(col.size() == 0)
			return null;
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		for(int x = 0; x < col.size(); x++)
		{
			String[] listOfOtherErrors = this.col.get(x).validate();
			if(listOfOtherErrors != null)
			{
				for(int y = 0; y < listOfOtherErrors.length; y++)
				{
					listOfErrors.add(listOfOtherErrors[y]);
				}
			}
		}
		
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
			return null;
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		return result;
	}
	public FurtherManagementDetailsVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public FurtherManagementDetailsVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public FurtherManagementDetailsVoCollection sort(SortOrder order)
	{
		return sort(new FurtherManagementDetailsVoComparator(order));
	}
	public FurtherManagementDetailsVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new FurtherManagementDetailsVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public FurtherManagementDetailsVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.RefMan.vo.FurtherManagementRefVoCollection toRefVoCollection()
	{
		ims.RefMan.vo.FurtherManagementRefVoCollection result = new ims.RefMan.vo.FurtherManagementRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public FurtherManagementDetailsVo[] toArray()
	{
		FurtherManagementDetailsVo[] arr = new FurtherManagementDetailsVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<FurtherManagementDetailsVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class FurtherManagementDetailsVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public FurtherManagementDetailsVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public FurtherManagementDetailsVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public FurtherManagementDetailsVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			FurtherManagementDetailsVo voObj1 = (FurtherManagementDetailsVo)obj1;
			FurtherManagementDetailsVo voObj2 = (FurtherManagementDetailsVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.RefMan.vo.beans.FurtherManagementDetailsVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.RefMan.vo.beans.FurtherManagementDetailsVoBean[] getBeanCollectionArray()
	{
		ims.RefMan.vo.beans.FurtherManagementDetailsVoBean[] result = new ims.RefMan.vo.beans.FurtherManagementDetailsVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			FurtherManagementDetailsVo vo = ((FurtherManagementDetailsVo)col.get(i));
			result[i] = (ims.RefMan.vo.beans.FurtherManagementDetailsVoBean)vo.getBean();
		}
		return result;
	}
	public static FurtherManagementDetailsVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		FurtherManagementDetailsVoCollection coll = new FurtherManagementDetailsVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.RefMan.vo.beans.FurtherManagementDetailsVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static FurtherManagementDetailsVoCollection buildFromBeanCollection(ims.RefMan.vo.beans.FurtherManagementDetailsVoBean[] beans)
	{
		FurtherManagementDetailsVoCollection coll = new FurtherManagementDetailsVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
