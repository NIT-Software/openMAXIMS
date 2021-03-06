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
 * Linked to RefMan.PresentationReferralSummary business object (ID: 1096100001).
 */
public class PresentationReferralSummaryVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<PresentationReferralSummaryVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<PresentationReferralSummaryVo> col = new ArrayList<PresentationReferralSummaryVo>();
	public String getBoClassName()
	{
		return "ims.RefMan.domain.objects.PresentationReferralSummary";
	}
	public boolean add(PresentationReferralSummaryVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, PresentationReferralSummaryVo value)
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
	public int indexOf(PresentationReferralSummaryVo instance)
	{
		return col.indexOf(instance);
	}
	public PresentationReferralSummaryVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, PresentationReferralSummaryVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(PresentationReferralSummaryVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(PresentationReferralSummaryVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		PresentationReferralSummaryVoCollection clone = new PresentationReferralSummaryVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((PresentationReferralSummaryVo)this.col.get(x).clone());
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
	public PresentationReferralSummaryVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public PresentationReferralSummaryVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public PresentationReferralSummaryVoCollection sort(SortOrder order)
	{
		return sort(new PresentationReferralSummaryVoComparator(order));
	}
	public PresentationReferralSummaryVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new PresentationReferralSummaryVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public PresentationReferralSummaryVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.RefMan.vo.PresentationReferralSummaryRefVoCollection toRefVoCollection()
	{
		ims.RefMan.vo.PresentationReferralSummaryRefVoCollection result = new ims.RefMan.vo.PresentationReferralSummaryRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public PresentationReferralSummaryVo[] toArray()
	{
		PresentationReferralSummaryVo[] arr = new PresentationReferralSummaryVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public ims.vo.interfaces.IPresentationReferralSummary[] toIPresentationReferralSummaryArray()
	{
		ims.vo.interfaces.IPresentationReferralSummary[] arr = new ims.vo.interfaces.IPresentationReferralSummary[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<PresentationReferralSummaryVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class PresentationReferralSummaryVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public PresentationReferralSummaryVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public PresentationReferralSummaryVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public PresentationReferralSummaryVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			PresentationReferralSummaryVo voObj1 = (PresentationReferralSummaryVo)obj1;
			PresentationReferralSummaryVo voObj2 = (PresentationReferralSummaryVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.RefMan.vo.beans.PresentationReferralSummaryVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.RefMan.vo.beans.PresentationReferralSummaryVoBean[] getBeanCollectionArray()
	{
		ims.RefMan.vo.beans.PresentationReferralSummaryVoBean[] result = new ims.RefMan.vo.beans.PresentationReferralSummaryVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			PresentationReferralSummaryVo vo = ((PresentationReferralSummaryVo)col.get(i));
			result[i] = (ims.RefMan.vo.beans.PresentationReferralSummaryVoBean)vo.getBean();
		}
		return result;
	}
	public static PresentationReferralSummaryVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		PresentationReferralSummaryVoCollection coll = new PresentationReferralSummaryVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.RefMan.vo.beans.PresentationReferralSummaryVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static PresentationReferralSummaryVoCollection buildFromBeanCollection(ims.RefMan.vo.beans.PresentationReferralSummaryVoBean[] beans)
	{
		PresentationReferralSummaryVoCollection coll = new PresentationReferralSummaryVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
