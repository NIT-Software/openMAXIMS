/*
 * This code was generated
 * Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.
 * IMS Development Environment (version 1.80 build 5007.25751)
 * WARNING: DO NOT MODIFY the content of this file
 * Generated: 16/04/2014, 12:34
 *
 */
package ims.RefMan.domain.objects;

/**
 * 
 * @author Neil McAnaspie
 * Generated.
 */


public class ClinicalOutcomeCategoryProcedureRequiredConfig extends ims.domain.DomainObject implements ims.domain.SystemInformationRetainer, java.io.Serializable {
	public static final int CLASSID = 1096100054;
	private static final long serialVersionUID = 1096100054L;
	public static final String CLASSVERSION = "${ClassVersion}";

	@Override
	public boolean shouldCapQuery()
	{
		return true;
	}

	/** Category */
	private ims.domain.lookups.LookupInstance category;
	/** When the outcome is recorded for the patient does it need to be linked to a Procedure */
	private Boolean requiresProcedureLink;
	/** SystemInformation */
	private ims.domain.SystemInformation systemInformation = new ims.domain.SystemInformation();
    public ClinicalOutcomeCategoryProcedureRequiredConfig (Integer id, int ver)
    {
    	super(id, ver);
    }
    public ClinicalOutcomeCategoryProcedureRequiredConfig ()
    {
    	super();
    }
    public ClinicalOutcomeCategoryProcedureRequiredConfig (Integer id, int ver, Boolean includeRecord)
    {
    	super(id, ver, includeRecord);
    }
	public Class getRealDomainClass()
	{
		return ims.RefMan.domain.objects.ClinicalOutcomeCategoryProcedureRequiredConfig.class;
	}


	public ims.domain.lookups.LookupInstance getCategory() {
		return category;
	}
	public void setCategory(ims.domain.lookups.LookupInstance category) {
		this.category = category;
	}

	public Boolean isRequiresProcedureLink() {
		return requiresProcedureLink;
	}
	public void setRequiresProcedureLink(Boolean requiresProcedureLink) {
		this.requiresProcedureLink = requiresProcedureLink;
	}

	public ims.domain.SystemInformation getSystemInformation() {
		if (systemInformation == null) systemInformation = new ims.domain.SystemInformation();
		return systemInformation;
	}


	/**
	 * isConfigurationObject
	 * Taken from the Usage property of the business object, this method will return
	 * a boolean indicating whether this is a configuration object or not
	 * Configuration = true, Instantiation = false
	 */
	public static boolean isConfigurationObject()
	{
		if ( "Instantiation".equals("Configuration") )
			return true;
		else
			return false;
	}
	// method generated based on 'clin_categ_idx1' unique index.
	public static boolean recordExistForCategory(ims.domain.ILightweightDomainFactory factory,
		 ims.domain.lookups.LookupInstance category
	)	
	{
		return recordExistForCategory(factory, category, null);
	}	

	// method generated based on 'clin_categ_idx1' unique index.
	public static boolean recordExistForCategory(ims.domain.ILightweightDomainFactory factory,
		 ims.domain.lookups.LookupInstance category
	, Integer recordId)	
	{
		String[] names = new String[1];
		Object[] values = new Object[1];
		StringBuffer hql = new StringBuffer();
		
		hql.append("from ClinicalOutcomeCategoryProcedureRequiredConfig c where ");
		hql.append(" c.category = :category ");
		names[0] = "category";
		values[0] = category;		
		if(recordId != null)
		{
			hql.append(" and c.id <> " + recordId);
		}
		
		return factory.count(hql.toString(), names, values) > 0;				
	}	

	// method generated based on 'clin_categ_idx1' unique index.
	public static ClinicalOutcomeCategoryProcedureRequiredConfig getRecordByCategory(ims.domain.ILightweightDomainFactory factory,
	 ims.domain.lookups.LookupInstance category
	)
	{
		String[] names = new String[1];
		Object[] values = new Object[1];
		StringBuffer hql = new StringBuffer();
		hql.append("from ClinicalOutcomeCategoryProcedureRequiredConfig c where ");
		hql.append(" c.category = :category ");
		names[0] = "category";
		values[0] = category;		
		java.util.List l = factory.find(hql.toString(), names, values);
		if (l == null || l.size() == 0) return null;
		if (l.size() > 1) throw new ims.domain.exceptions.DomainRuntimeException("Non-unique get call. " + hql + " returned " + l.size() + " records. " );
		return (ClinicalOutcomeCategoryProcedureRequiredConfig)l.get(0);
	}

	public static ClinicalOutcomeCategoryProcedureRequiredConfig getClinicalOutcomeCategoryProcedureRequiredConfigFromclin_categ_idx1(ims.domain.ILightweightDomainFactory factory,
	 ims.domain.lookups.LookupInstance category
	)
	{
		String[] names = new String[1];
		Object[] values = new Object[1];
		StringBuffer hql = new StringBuffer();
		hql.append("from ClinicalOutcomeCategoryProcedureRequiredConfig c where ");
		hql.append(" c.category = :category ");
		names[0] = "category";
		values[0] = category;		
		java.util.List l = factory.find(hql.toString(), names, values);
		if (l == null || l.size() == 0) return null;
		if (l.size() > 1) throw new ims.domain.exceptions.DomainRuntimeException("Non-unique get call. " + hql + " returned " + l.size() + " records. " );
		return (ClinicalOutcomeCategoryProcedureRequiredConfig)l.get(0);
	}


	public int getClassId() {
		return CLASSID;
	}

	public String getClassVersion()
	{
		return CLASSVERSION;
	}

	public String toAuditString()
	{
		StringBuffer auditStr = new StringBuffer();
		
		auditStr.append("\r\n*category* :");
		if (category != null)
			auditStr.append(category.getText());
	    auditStr.append("; ");
		auditStr.append("\r\n*requiresProcedureLink* :");
		auditStr.append(requiresProcedureLink);
	    auditStr.append("; ");
		return auditStr.toString();
	}
	
	public String toXMLString()
	{
		return toXMLString(new java.util.HashMap());
	}
	
	public String toXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<class type=\"" + this.getClass().getName() + "\" ");		
		sb.append(" id=\"" + this.getId() + "\""); 
		sb.append(" source=\"" + ims.configuration.EnvironmentConfig.getImportExportSourceName() + "\" ");
		sb.append(" classVersion=\"" + this.getClassVersion() + "\" ");
		sb.append(" component=\"" + this.getIsComponentClass() + "\" >");
		
		if (domMap.get(this) == null)
		{
			domMap.put(this, this);
			sb.append(this.fieldsToXMLString(domMap));
		}
		sb.append("</class>");
		
		String keyClassName = "ClinicalOutcomeCategoryProcedureRequiredConfig";
		String externalSource = ims.configuration.EnvironmentConfig.getImportExportSourceName();
		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + this.getId());
		if (impObj == null)
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(this.getId());
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(this);
			impObj.setLocalId(this.getId()); 
    		impObj.setClassName(keyClassName); 
			domMap.put(keyClassName + "_" + externalSource + "_" + this.getId(), impObj);
		}
		
		return sb.toString();
	}

	public String fieldsToXMLString(java.util.HashMap domMap)
	{
		StringBuffer sb = new StringBuffer();
		if (this.getCategory() != null)
		{
			sb.append("<category>");
			sb.append(this.getCategory().toXMLString()); 
			sb.append("</category>");		
		}
		if (this.isRequiresProcedureLink() != null)
		{
			sb.append("<requiresProcedureLink>");
			sb.append(ims.framework.utils.StringUtils.encodeXML(this.isRequiresProcedureLink().toString()));
			sb.append("</requiresProcedureLink>");		
		}
		return sb.toString();
	}
		
	public static java.util.List fromListXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.List list, java.util.HashMap domMap) throws Exception
	{
		if (list == null)
		 list = new java.util.ArrayList();
		fillListFromXMLString(list, el, factory, domMap);
		return list;
	}
	
	public static java.util.Set fromSetXMLString(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.Set set, java.util.HashMap domMap) throws Exception
	{
		if (set == null)
			 set = new java.util.HashSet();
		fillSetFromXMLString(set, el, factory, domMap);
		return set;
	}
	
	private static void fillSetFromXMLString(java.util.Set set, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		java.util.Set newSet = new java.util.HashSet();
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			ClinicalOutcomeCategoryProcedureRequiredConfig domainObject = getClinicalOutcomeCategoryProcedureRequiredConfigfromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}
			
			//Trying to avoid the hibernate collection being marked as dirty via its public interface methods. (like add)
			if (!set.contains(domainObject)) 
				set.add(domainObject);
			newSet.add(domainObject);			
		}
		
		java.util.Set removedSet = new java.util.HashSet();
		java.util.Iterator iter = set.iterator();
		//Find out which objects need to be removed
		while (iter.hasNext())
		{
			ims.domain.DomainObject o = (ims.domain.DomainObject)iter.next();			
			if ((o == null || o.getIsRIE() == null || !o.getIsRIE().booleanValue()) && !newSet.contains(o))
			{
				removedSet.add(o);
			}
		}
		iter = removedSet.iterator();
		//Remove the unwanted objects
		while (iter.hasNext())
		{
			set.remove(iter.next());
		}		
	}
	
	private static void fillListFromXMLString(java.util.List list, org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return;
		
		java.util.List cl = el.elements("class");
		int size = cl.size();
		
		for(int i=0; i<size; i++) 
		{
			org.dom4j.Element itemEl = (org.dom4j.Element)cl.get(i);
			ClinicalOutcomeCategoryProcedureRequiredConfig domainObject = getClinicalOutcomeCategoryProcedureRequiredConfigfromXML(itemEl, factory, domMap);

			if (domainObject == null)
			{
				continue;
			}

			int domIdx = list.indexOf(domainObject);
			if (domIdx == -1)
			{
				list.add(i, domainObject);
			}
			else if (i != domIdx && i < list.size())
			{
				Object tmp = list.get(i);
				list.set(i, list.get(domIdx));
				list.set(domIdx, tmp);
			}
		}		
		
		//Remove all ones in domList where index > voCollection.size() as these should
		//now represent the ones removed from the VO collection. No longer referenced.
		int i1=list.size();
		while (i1 > size)
		{
			list.remove(i1-1);
			i1=list.size();
		}
	}
		
	public static ClinicalOutcomeCategoryProcedureRequiredConfig getClinicalOutcomeCategoryProcedureRequiredConfigfromXML(String xml, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Document doc = new org.dom4j.io.SAXReader().read(new org.xml.sax.InputSource(xml));
		return getClinicalOutcomeCategoryProcedureRequiredConfigfromXML(doc.getRootElement(), factory, domMap);
	}
	
	public static ClinicalOutcomeCategoryProcedureRequiredConfig getClinicalOutcomeCategoryProcedureRequiredConfigfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, java.util.HashMap domMap) throws Exception
	{
		if (el == null)
			return null;
		
		String className = el.attributeValue("type");
		if (!ClinicalOutcomeCategoryProcedureRequiredConfig.class.getName().equals(className))
		{
			Class clz = Class.forName(className);
			if (!ClinicalOutcomeCategoryProcedureRequiredConfig.class.isAssignableFrom(clz))
				throw new Exception("Element of type = " + className + " cannot be imported using the ClinicalOutcomeCategoryProcedureRequiredConfig class");
			String shortClassName = className.substring(className.lastIndexOf(".")+1);
			String methodName = "get" + shortClassName + "fromXML";
			java.lang.reflect.Method m = clz.getMethod(methodName, new Class[]{org.dom4j.Element.class, ims.domain.DomainFactory.class, java.util.HashMap.class});
			return (ClinicalOutcomeCategoryProcedureRequiredConfig)m.invoke(null, new Object[]{el, factory, domMap});
		}

		String impVersion = el.attributeValue("classVersion");
		if(!impVersion.equals(ClinicalOutcomeCategoryProcedureRequiredConfig.CLASSVERSION))
		{
			throw new Exception("Incompatible class structure found. Cannot import instance.");
		}		
		
		ClinicalOutcomeCategoryProcedureRequiredConfig ret = null;
		int extId = Integer.parseInt(el.attributeValue("id"));
		String externalSource = el.attributeValue("source");
		ret = (ClinicalOutcomeCategoryProcedureRequiredConfig)factory.getImportedDomainObject(ClinicalOutcomeCategoryProcedureRequiredConfig.class, externalSource, extId);	
		if (ret == null)
		{
			ret = new ClinicalOutcomeCategoryProcedureRequiredConfig();
		}
		String keyClassName = "ClinicalOutcomeCategoryProcedureRequiredConfig";

		ims.configuration.ImportedObject impObj = (ims.configuration.ImportedObject)domMap.get(keyClassName + "_" + externalSource + "_" + extId);
		if (impObj != null)
		{
			return (ClinicalOutcomeCategoryProcedureRequiredConfig)impObj.getDomainObject();
		}
		else
		{
    		impObj = new ims.configuration.ImportedObject();
    		impObj.setExternalId(extId);
    		impObj.setExternalSource(externalSource);
    		impObj.setDomainObject(ret);
			domMap.put(keyClassName + "_" + externalSource + "_" + extId, impObj);
		}
		fillFieldsfromXML(el, factory, ret, domMap);
		return ret;
	}

	public static void fillFieldsfromXML(org.dom4j.Element el, ims.domain.DomainFactory factory, ClinicalOutcomeCategoryProcedureRequiredConfig obj, java.util.HashMap domMap) throws Exception
	{
		org.dom4j.Element fldEl;
		fldEl = el.element("category");
		if(fldEl != null)
		{
			fldEl = fldEl.element("lki");
			obj.setCategory(ims.domain.lookups.LookupInstance.fromXMLString(fldEl, factory)); 	
		}
		fldEl = el.element("requiresProcedureLink");
		if(fldEl != null)
		{	
    		obj.setRequiresProcedureLink(new Boolean(fldEl.getTextTrim()));	
		}
	}

	public static String[] getCollectionFields()
	{
		return new String[]{
		};
	}


	public static class FieldNames	
	{
	public static final String ID = "id";
		public static final String Category = "category";
		public static final String RequiresProcedureLink = "requiresProcedureLink";
	}
}

