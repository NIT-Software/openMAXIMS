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
 * Linked to core.clinical.CsPrimaryDiagnosis business object (ID: 1003100065).
 */
public class CSPrimaryDiagnosisForClinicalNotesVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<CSPrimaryDiagnosisForClinicalNotesVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<CSPrimaryDiagnosisForClinicalNotesVo> col = new ArrayList<CSPrimaryDiagnosisForClinicalNotesVo>();
	public String getBoClassName()
	{
		return "ims.core.clinical.domain.objects.CsPrimaryDiagnosis";
	}
	public boolean add(CSPrimaryDiagnosisForClinicalNotesVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, CSPrimaryDiagnosisForClinicalNotesVo value)
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
	public int indexOf(CSPrimaryDiagnosisForClinicalNotesVo instance)
	{
		return col.indexOf(instance);
	}
	public CSPrimaryDiagnosisForClinicalNotesVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, CSPrimaryDiagnosisForClinicalNotesVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(CSPrimaryDiagnosisForClinicalNotesVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(CSPrimaryDiagnosisForClinicalNotesVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		CSPrimaryDiagnosisForClinicalNotesVoCollection clone = new CSPrimaryDiagnosisForClinicalNotesVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((CSPrimaryDiagnosisForClinicalNotesVo)this.col.get(x).clone());
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
	public CSPrimaryDiagnosisForClinicalNotesVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public CSPrimaryDiagnosisForClinicalNotesVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public CSPrimaryDiagnosisForClinicalNotesVoCollection sort(SortOrder order)
	{
		return sort(new CSPrimaryDiagnosisForClinicalNotesVoComparator(order));
	}
	public CSPrimaryDiagnosisForClinicalNotesVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new CSPrimaryDiagnosisForClinicalNotesVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public CSPrimaryDiagnosisForClinicalNotesVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.core.clinical.vo.CsPrimaryDiagnosisRefVoCollection toRefVoCollection()
	{
		ims.core.clinical.vo.CsPrimaryDiagnosisRefVoCollection result = new ims.core.clinical.vo.CsPrimaryDiagnosisRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public CSPrimaryDiagnosisForClinicalNotesVo[] toArray()
	{
		CSPrimaryDiagnosisForClinicalNotesVo[] arr = new CSPrimaryDiagnosisForClinicalNotesVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<CSPrimaryDiagnosisForClinicalNotesVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class CSPrimaryDiagnosisForClinicalNotesVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public CSPrimaryDiagnosisForClinicalNotesVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public CSPrimaryDiagnosisForClinicalNotesVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public CSPrimaryDiagnosisForClinicalNotesVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			CSPrimaryDiagnosisForClinicalNotesVo voObj1 = (CSPrimaryDiagnosisForClinicalNotesVo)obj1;
			CSPrimaryDiagnosisForClinicalNotesVo voObj2 = (CSPrimaryDiagnosisForClinicalNotesVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.RefMan.vo.beans.CSPrimaryDiagnosisForClinicalNotesVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.RefMan.vo.beans.CSPrimaryDiagnosisForClinicalNotesVoBean[] getBeanCollectionArray()
	{
		ims.RefMan.vo.beans.CSPrimaryDiagnosisForClinicalNotesVoBean[] result = new ims.RefMan.vo.beans.CSPrimaryDiagnosisForClinicalNotesVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			CSPrimaryDiagnosisForClinicalNotesVo vo = ((CSPrimaryDiagnosisForClinicalNotesVo)col.get(i));
			result[i] = (ims.RefMan.vo.beans.CSPrimaryDiagnosisForClinicalNotesVoBean)vo.getBean();
		}
		return result;
	}
	public static CSPrimaryDiagnosisForClinicalNotesVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		CSPrimaryDiagnosisForClinicalNotesVoCollection coll = new CSPrimaryDiagnosisForClinicalNotesVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.RefMan.vo.beans.CSPrimaryDiagnosisForClinicalNotesVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static CSPrimaryDiagnosisForClinicalNotesVoCollection buildFromBeanCollection(ims.RefMan.vo.beans.CSPrimaryDiagnosisForClinicalNotesVoBean[] beans)
	{
		CSPrimaryDiagnosisForClinicalNotesVoCollection coll = new CSPrimaryDiagnosisForClinicalNotesVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
