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
 * Linked to RefMan.ReportNote business object (ID: 1096100040).
 */
public class ReportNoteRefVoCollection extends ims.vo.ValueObjectCollection implements ims.domain.IDomainCollectionGetter, ims.vo.ImsCloneable, Iterable<ReportNoteRefVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<ReportNoteRefVo> col = new ArrayList<ReportNoteRefVo>();
	public final String getBoClassName()
	{
		return "ims.RefMan.domain.objects.ReportNote";
	}
	public ims.domain.IDomainGetter[] getIDomainGetterItems()
	{
		ims.domain.IDomainGetter[] result = new ims.domain.IDomainGetter[col.size()];
		col.toArray(result);
		return result;
	}
	public boolean add(ReportNoteRefVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, ReportNoteRefVo value)
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
	public int indexOf(ReportNoteRefVo instance)
	{
		return col.indexOf(instance);
	}
	public ReportNoteRefVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, ReportNoteRefVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(ReportNoteRefVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(ReportNoteRefVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		ReportNoteRefVoCollection clone = new ReportNoteRefVoCollection();

		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((ReportNoteRefVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		return clone;
	}
	public boolean isValidated()
	{
		return true;
	}
	public String[] validate()
	{
		return null;
	}
	public ReportNoteRefVo[] toArray()
	{
		ReportNoteRefVo[] arr = new ReportNoteRefVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public ReportNoteRefVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public ReportNoteRefVoCollection sort(SortOrder order)
	{
		return sort(new ReportNoteRefVoComparator(order));
	}
	@SuppressWarnings("unchecked")
	public ReportNoteRefVoCollection sort(Comparator comparator)
	{
		Collections.sort(this.col, comparator);
		return this;
	}
	public Iterator<ReportNoteRefVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class ReportNoteRefVoComparator implements Comparator
	{
		private int direction = 1;
		public ReportNoteRefVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public ReportNoteRefVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				this.direction = -1;
			}
		}
		public int compare(Object obj1, Object obj2)
		{
			ReportNoteRefVo voObj1 = (ReportNoteRefVo)obj1;
			ReportNoteRefVo voObj2 = (ReportNoteRefVo)obj2;
			return direction*(voObj1.compareTo(voObj2));
		}
	}
}
