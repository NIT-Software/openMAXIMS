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
 * Linked to RefMan.NursingNotes business object (ID: 1096100002).
 */
public class BaselineObservationsVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<BaselineObservationsVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<BaselineObservationsVo> col = new ArrayList<BaselineObservationsVo>();
	public String getBoClassName()
	{
		return "ims.RefMan.domain.objects.NursingNotes";
	}
	public boolean add(BaselineObservationsVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, BaselineObservationsVo value)
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
	public int indexOf(BaselineObservationsVo instance)
	{
		return col.indexOf(instance);
	}
	public BaselineObservationsVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, BaselineObservationsVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(BaselineObservationsVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(BaselineObservationsVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		BaselineObservationsVoCollection clone = new BaselineObservationsVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((BaselineObservationsVo)this.col.get(x).clone());
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
	public BaselineObservationsVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public BaselineObservationsVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public BaselineObservationsVoCollection sort(SortOrder order)
	{
		return sort(new BaselineObservationsVoComparator(order));
	}
	public BaselineObservationsVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new BaselineObservationsVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public BaselineObservationsVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.RefMan.vo.NursingNotesRefVoCollection toRefVoCollection()
	{
		ims.RefMan.vo.NursingNotesRefVoCollection result = new ims.RefMan.vo.NursingNotesRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public BaselineObservationsVo[] toArray()
	{
		BaselineObservationsVo[] arr = new BaselineObservationsVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<BaselineObservationsVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class BaselineObservationsVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public BaselineObservationsVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public BaselineObservationsVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public BaselineObservationsVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			BaselineObservationsVo voObj1 = (BaselineObservationsVo)obj1;
			BaselineObservationsVo voObj2 = (BaselineObservationsVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.RefMan.vo.beans.BaselineObservationsVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.RefMan.vo.beans.BaselineObservationsVoBean[] getBeanCollectionArray()
	{
		ims.RefMan.vo.beans.BaselineObservationsVoBean[] result = new ims.RefMan.vo.beans.BaselineObservationsVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			BaselineObservationsVo vo = ((BaselineObservationsVo)col.get(i));
			result[i] = (ims.RefMan.vo.beans.BaselineObservationsVoBean)vo.getBean();
		}
		return result;
	}
	public static BaselineObservationsVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		BaselineObservationsVoCollection coll = new BaselineObservationsVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.RefMan.vo.beans.BaselineObservationsVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static BaselineObservationsVoCollection buildFromBeanCollection(ims.RefMan.vo.beans.BaselineObservationsVoBean[] beans)
	{
		BaselineObservationsVoCollection coll = new BaselineObservationsVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
