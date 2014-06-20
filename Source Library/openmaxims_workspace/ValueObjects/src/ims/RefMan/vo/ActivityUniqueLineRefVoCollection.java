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
 * Linked to RefMan.ActivityUniqueLineRef business object (ID: 1096100023).
 */
public class ActivityUniqueLineRefVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<ActivityUniqueLineRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<ActivityUniqueLineRefVo> col = new ArrayList<ActivityUniqueLineRefVo>();
	public String getBoClassName()
	{
		return "ims.RefMan.domain.objects.ActivityUniqueLineRef";
	}
	public boolean add(ActivityUniqueLineRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, ActivityUniqueLineRefVo value)
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
	public int indexOf(ActivityUniqueLineRefVo instance)
	{
		return col.indexOf(instance);
	}
	public ActivityUniqueLineRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, ActivityUniqueLineRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(ActivityUniqueLineRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(ActivityUniqueLineRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		ActivityUniqueLineRefVoCollection clone = new ActivityUniqueLineRefVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((ActivityUniqueLineRefVo)this.col.get(x).clone());
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
	public ActivityUniqueLineRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public ActivityUniqueLineRefVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public ActivityUniqueLineRefVoCollection sort(SortOrder order)
	{
		return sort(new ActivityUniqueLineRefVoComparator(order));
	}
	public ActivityUniqueLineRefVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new ActivityUniqueLineRefVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public ActivityUniqueLineRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.RefMan.vo.ActivityUniqueLineRefRefVoCollection toRefVoCollection()
	{
		ims.RefMan.vo.ActivityUniqueLineRefRefVoCollection result = new ims.RefMan.vo.ActivityUniqueLineRefRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public ActivityUniqueLineRefVo[] toArray()
	{
		ActivityUniqueLineRefVo[] arr = new ActivityUniqueLineRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<ActivityUniqueLineRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class ActivityUniqueLineRefVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public ActivityUniqueLineRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public ActivityUniqueLineRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public ActivityUniqueLineRefVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			ActivityUniqueLineRefVo voObj1 = (ActivityUniqueLineRefVo)obj1;
			ActivityUniqueLineRefVo voObj2 = (ActivityUniqueLineRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.RefMan.vo.beans.ActivityUniqueLineRefVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.RefMan.vo.beans.ActivityUniqueLineRefVoBean[] getBeanCollectionArray()
	{
		ims.RefMan.vo.beans.ActivityUniqueLineRefVoBean[] result = new ims.RefMan.vo.beans.ActivityUniqueLineRefVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			ActivityUniqueLineRefVo vo = ((ActivityUniqueLineRefVo)col.get(i));
			result[i] = (ims.RefMan.vo.beans.ActivityUniqueLineRefVoBean)vo.getBean();
		}
		return result;
	}
	public static ActivityUniqueLineRefVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		ActivityUniqueLineRefVoCollection coll = new ActivityUniqueLineRefVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.RefMan.vo.beans.ActivityUniqueLineRefVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static ActivityUniqueLineRefVoCollection buildFromBeanCollection(ims.RefMan.vo.beans.ActivityUniqueLineRefVoBean[] beans)
	{
		ActivityUniqueLineRefVoCollection coll = new ActivityUniqueLineRefVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
