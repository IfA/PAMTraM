/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
/**
 */
package pamtram.structure.generic;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This represents one element (as an instance of an EClass) of an element structure.
 * <br />
 * In order to allow for the description of complex element structures, Classes can be equipped with Attributes and References (which itself may reference/contain other Classes).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.structure.generic.Class#getEClass <em>EClass</em>}</li>
 *   <li>{@link pamtram.structure.generic.Class#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link pamtram.structure.generic.Class#getReferences <em>References</em>}</li>
 *   <li>{@link pamtram.structure.generic.Class#getContainer <em>Container</em>}</li>
 *   <li>{@link pamtram.structure.generic.Class#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link pamtram.structure.generic.Class#getAllContainer <em>All Container</em>}</li>
 *   <li>{@link pamtram.structure.generic.Class#getActualAttributes <em>Actual Attributes</em>}</li>
 *   <li>{@link pamtram.structure.generic.Class#getVirtualAttributes <em>Virtual Attributes</em>}</li>
 *   <li>{@link pamtram.structure.generic.Class#getActualReferences <em>Actual References</em>}</li>
 *   <li>{@link pamtram.structure.generic.Class#getVirtualReferences <em>Virtual References</em>}</li>
 *   <li>{@link pamtram.structure.generic.Class#getAllAttributes <em>All Attributes</em>}</li>
 *   <li>{@link pamtram.structure.generic.Class#getAllReferences <em>All References</em>}</li>
 *   <li>{@link pamtram.structure.generic.Class#getAllConcreteExtending <em>All Concrete Extending</em>}</li>
 *   <li>{@link pamtram.structure.generic.Class#getAllCompositeReferences <em>All Composite References</em>}</li>
 *   <li>{@link pamtram.structure.generic.Class#getAllCrossReferences <em>All Cross References</em>}</li>
 * </ul>
 *
 * @see pamtram.structure.generic.GenericPackage#getClass_()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='eClassMatchesParentEReference variableCardinalityIsValid containerIsValid'"
 * @generated
 */
public interface Class<S extends Section<S, C, R, A>, C extends Class<S, C, R, A>, R extends Reference<S, C, R, A>, A extends Attribute<S, C, R, A>> extends MetaModelElement<S, C, R, A> {
	/**
	 * Returns the value of the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EClass</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The metamodel element (EClass) that this Class represents.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>EClass</em>' reference.
	 * @see #setEClass(EClass)
	 * @see pamtram.structure.generic.GenericPackage#getClass_EClass()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescriptor='\r\nitemPropertyDescriptors\r\n\t\t.add(new ItemPropertyDescriptor(((&lt;%org.eclipse.emf.edit.provider.ComposeableAdapterFactory%&gt;) adapterFactory).getRootAdapterFactory(),\r\n\t\t\t\tthis.getResourceLocator(), this.getString(\"_UI_Class_eClass_feature\"),\r\n\t\t\t\tthis.getString(\"_UI_Class_eClass_description\", \"_UI_Class_eClass_feature\", \"_UI_Class_type\"),\r\n\t\t\t\t&lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.CLASS__ECLASS, true, false, true, null,\r\n\t\t\t\tthis.getString(\"_UI_BasicPropertyCategory\"), null) {\r\n\r\n\t\t\t@Override\r\n\t\t\tpublic &lt;%java.util.Collection%&gt;&lt;?&gt; getChoiceOfValues(Object object) {\r\n\r\n\t\t\t\tpamtram.structure.generic.Class&lt;?, ?, ?, ?&gt; selectedClass = (&lt;%pamtram.structure.generic.Class%&gt;&lt;?, ?, ?, ?&gt;) object;\r\n\t\t\t\t&lt;%pamtram.structure.generic.Section%&gt;&lt;?, ?, ?, ?&gt; containingSection = selectedClass.getContainingSection();\r\n\r\n\t\t\t\t/*\r\n\t\t\t\t * If we have a container parameter with a specified source, we do not need to scan package\r\n\t\t\t\t * contents. Instead, the user may only select the eClass of the specified source element.\r\n\t\t\t\t \052/\r\n\t\t\t\tif (containingSection.eContainer() instanceof &lt;%pamtram.structure.library.ContainerParameter%&gt;\r\n\t\t\t\t\t\t&amp;&amp; ((ContainerParameter) containingSection.eContainer()).getSource() != null) {\r\n\t\t\t\t\treturn &lt;%java.util.Arrays%&gt;\r\n\t\t\t\t\t\t\t.asList(((ContainerParameter) containingSection.eContainer()).getSource().eClass());\r\n\t\t\t\t}\r\n\r\n\t\t\t\t&lt;%pamtram.SectionModel%&gt;&lt;?, ?, ?, ?&gt; containingSectionModel = containingSection.getContainingSectionModel();\r\n\r\n\t\t\t\tif (containingSectionModel.getMetaModelPackage() == null) {\r\n\t\t\t\t\treturn &lt;%java.util.Collections%&gt;.emptyList();\r\n\t\t\t\t}\r\n\r\n\t\t\t\tboolean selectedClassIsSection = containingSection.equals(object);\r\n\r\n\t\t\t\t&lt;%java.util.List%&gt;&lt;&lt;%org.eclipse.emf.ecore.EClass%&gt;&gt; choiceOfValues = new &lt;%java.util.ArrayList%&gt;&lt;&gt;();\r\n\r\n\t\t\t\tList&lt;SectionModel&lt;?, ?, ?, ?&gt;&gt; sectionModelsToConsider = new ArrayList&lt;&gt;();\r\n\t\t\t\tif (&lt;%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%&gt;.hasAncestorOfKind(containingSection, &lt;%pamtram.PamtramPackage%&gt;.Literals.PAM_TRA_M)) {\r\n\t\t\t\t\tif (containingSection instanceof &lt;%pamtram.structure.source.SourceSection%&gt;) {\r\n\t\t\t\t\t\tsectionModelsToConsider\r\n\t\t\t\t\t\t\t\t.addAll(((&lt;%pamtram.PAMTraM%&gt;) AgteleEcoreUtil.getAncestorOfKind(containingSection,\r\n\t\t\t\t\t\t\t\t\t\tPamtramPackage.Literals.PAM_TRA_M)).getSourceSectionModels());\r\n\t\t\t\t\t} else if (containingSection instanceof &lt;%pamtram.structure.target.TargetSection%&gt;) {\r\n\t\t\t\t\t\tsectionModelsToConsider\r\n\t\t\t\t\t\t\t\t.addAll(((PAMTraM) AgteleEcoreUtil.getAncestorOfKind(containingSection,\r\n\t\t\t\t\t\t\t\t\t\tPamtramPackage.Literals.PAM_TRA_M)).getTargetSectionModels());\r\n\t\t\t\t\t}\r\n\t\t\t\t} else {\r\n\t\t\t\t\tsectionModelsToConsider.add((SectionModel&lt;?, ?, ?, ?&gt;) AgteleEcoreUtil\r\n\t\t\t\t\t\t\t.getAncestorOfKind(containingSection, PamtramPackage.Literals.SECTION_MODEL));\r\n\t\t\t\t}\r\n\r\n\t\t\t\t&lt;%java.util.Set%&gt;&lt;&lt;%org.eclipse.emf.ecore.EPackage%&gt;&gt; ePackagesOfSectionModelsToConsider = sectionModelsToConsider.stream()\r\n\t\t\t\t\t\t.map(SectionModel::getMetaModelPackage).collect(&lt;%java.util.stream.Collectors%&gt;.toSet());\r\n\r\n\t\t\t\tSet&lt;EPackage&gt; packagesToScan = &lt;%de.tud.et.ifa.agtele.emf.EPackageHelper%&gt;.collectEPackages(\r\n\t\t\t\t\t\tePackagesOfSectionModelsToConsider, true, true, !selectedClassIsSection,\r\n\t\t\t\t\t\t&lt;%java.util.Optional%&gt;.empty());\r\n\r\n\t\t\t\tfor (EPackage pkg : packagesToScan) {\r\n\r\n\t\t\t\t\tEClass docroot = &lt;%org.eclipse.emf.ecore.util.ExtendedMetaData%&gt;.INSTANCE.getDocumentRoot(pkg);\r\n\r\n\t\t\t\t\tList&lt;EClass&gt; classesInPackage = pkg.getEClassifiers().stream()\r\n\t\t\t\t\t\t\t.filter(EClass.class::isInstance).map(EClass.class::cast)\r\n\t\t\t\t\t\t\t.collect(Collectors.toList());\r\n\t\t\t\t\tfor (EClass eClass : classesInPackage) {\r\n\r\n\t\t\t\t\t\t// Do not consider DocRoot classes; Abstract EClasses are only allowed for\r\n\t\t\t\t\t\t// SourceSections or abstract TargetSections\r\n\t\t\t\t\t\t//\r\n\t\t\t\t\t\tif (!eClass.equals(docroot) &amp;&amp; (!eClass.isAbstract()\r\n\t\t\t\t\t\t\t\t|| object instanceof &lt;%pamtram.structure.source.SourceSectionClass%&gt;\r\n\t\t\t\t\t\t\t\t|| object instanceof TargetSection &amp;&amp; ((TargetSection) object).isAbstract())) {\r\n\t\t\t\t\t\t\tchoiceOfValues.add(eClass);\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t}\r\n\t\t\t\t}\r\n\r\n\t\t\t\tif (selectedClassIsSection) { // top level-section\r\n\t\t\t\t\treturn choiceOfValues;\r\n\t\t\t\t} else { // not a top-level section\r\n\t\t\t\t\tList&lt;EClass&gt; newChoiceOfValues = new &lt;%java.util.LinkedList%&gt;&lt;&gt;();\r\n\t\t\t\t\t&lt;%pamtram.structure.generic.Reference%&gt;&lt;?, ?, ?, ?&gt; ref = (Reference&lt;?, ?, ?, ?&gt;) ((Class&lt;?, ?, ?, ?&gt;) object)\r\n\t\t\t\t\t\t\t.eContainer();\r\n\t\t\t\t\tif (ref instanceof &lt;%pamtram.structure.generic.ActualReference%&gt;&lt;?, ?, ?, ?&gt;\r\n\t\t\t\t\t\t\t&amp;&amp; ((ActualReference&lt;?, ?, ?, ?&gt;) ref).getEReference() != null) {\r\n\t\t\t\t\t\tif (!(((ActualReference&lt;?, ?, ?, ?&gt;) ref).getEReference()\r\n\t\t\t\t\t\t\t\t.getEType() instanceof EClass)) {\r\n\t\t\t\t\t\t\tthrow new RuntimeException(\r\n\t\t\t\t\t\t\t\t\t\"Type checks can only be performed for instances of type \'EClass\'\");\r\n\t\t\t\t\t\t} else {\r\n\t\t\t\t\t\t\tEClass refClass = null;\r\n\r\n\t\t\t\t\t\t\ttry {\r\n\t\t\t\t\t\t\t\trefClass = (EClass) ((ActualReference&lt;?, ?, ?, ?&gt;) ref).getEReference()\r\n\t\t\t\t\t\t\t\t\t\t.getEGenericType().getERawType();\r\n\t\t\t\t\t\t\t} catch (Exception e) {\r\n\t\t\t\t\t\t\t\trefClass = (EClass) ((ActualReference&lt;?, ?, ?, ?&gt;) ref).getEReference()\r\n\t\t\t\t\t\t\t\t\t\t.getEType();\r\n\t\t\t\t\t\t\t}\r\n\r\n\t\t\t\t\t\t\tif (&lt;%org.eclipse.emf.ecore.EcorePackage%&gt;.Literals.EOBJECT.equals(refClass)) {\r\n\t\t\t\t\t\t\t\tnewChoiceOfValues.addAll(choiceOfValues);\r\n\t\t\t\t\t\t\t} else if (refClass != null) {\r\n\r\n\t\t\t\t\t\t\t\tfor (EClass c : choiceOfValues) {\r\n\t\t\t\t\t\t\t\t\tif (refClass.isSuperTypeOf(c)) {\r\n\t\t\t\t\t\t\t\t\t\tnewChoiceOfValues.add(c);\r\n\t\t\t\t\t\t\t\t\t}\r\n\t\t\t\t\t\t\t\t}\r\n\t\t\t\t\t\t\t}\r\n\t\t\t\t\t\t\treturn newChoiceOfValues;\r\n\r\n\t\t\t\t\t\t}\r\n\r\n\t\t\t\t\t}\r\n\r\n\t\t\t\t}\r\n\t\t\t\treturn super.getChoiceOfValues(object);\r\n\t\t\t}\r\n\r\n\t\t});'"
	 * @generated
	 */
	EClass getEClass();

	/**
	 * Sets the value of the '{@link pamtram.structure.generic.Class#getEClass <em>EClass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EClass</em>' reference.
	 * @see #getEClass()
	 * @generated
	 */
	void setEClass(EClass value);

	/**
	 * Returns the value of the '<em><b>Cardinality</b></em>' attribute.
	 * The default value is <code>"ONE"</code>.
	 * The literals are from the enumeration {@link pamtram.structure.generic.CardinalityType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cardinality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This can be used to specify a cardinality constraint for this element.
	 * <br />
	 * For example, setting this to 'ONE' means that exactly one element must be present to be matched (for SourceSections) resp. will be created during the execution of one mapping (for TargetSections).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cardinality</em>' attribute.
	 * @see pamtram.structure.generic.CardinalityType
	 * @see #setCardinality(CardinalityType)
	 * @see pamtram.structure.generic.GenericPackage#getClass_Cardinality()
	 * @model default="ONE" required="true"
	 * @generated
	 */
	CardinalityType getCardinality();

	/**
	 * Sets the value of the '{@link pamtram.structure.generic.Class#getCardinality <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cardinality</em>' attribute.
	 * @see pamtram.structure.generic.CardinalityType
	 * @see #getCardinality()
	 * @generated
	 */
	void setCardinality(CardinalityType value);

	/**
	 * Returns the value of the '<em><b>References</b></em>' containment reference list.
	 * It is bidirectional and its opposite is '{@link pamtram.structure.generic.Reference#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of References based on which further elements of the element structure a specified.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>References</em>' containment reference list.
	 * @see pamtram.structure.generic.GenericPackage#getClass_References()
	 * @see pamtram.structure.generic.Reference#getOwningClass
	 * @model opposite="owningClass" containment="true"
	 * @generated
	 */
	EList<R> getReferences();

	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This can be used to specify additional constraints on the containment structure of the current element structure.
	 * <br />
	 * For SourceSections: By setting the 'container' reference, SourceSections will only be matched if the specified container Class can also be matched in the source model.
	 * <br />
	 * For TargetSections: Created target structures will automatically connected to (contained by) an instance of the specified container Class.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #setContainer(Class)
	 * @see pamtram.structure.generic.GenericPackage#getClass_Container()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescriptor='\r\nitemPropertyDescriptors.add(new ItemPropertyDescriptor(\r\n\t\t((&lt;%org.eclipse.emf.edit.provider.ComposeableAdapterFactory%&gt;) adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),\r\n\t\tthis.getString(\"_UI_Class_container_feature\"),\r\n\t\tobject instanceof &lt;%pamtram.structure.source.SourceSectionClass%&gt; ? this.getString(\"_UI_SourceSectionClass_container_description\")\r\n\t\t\t\t: this.getString(\"_UI_TargetSectionClass_container_description\"),\r\n\t\t&lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.CLASS__CONTAINER, true, false, true, null,\r\n\t\tthis.getString(\"_UI_ExtendedPropertyCategory\"), null) {\r\n\r\n\t@Override\r\n\tpublic &lt;%java.util.Collection%&gt;&lt;?&gt; getChoiceOfValues(Object object) {\r\n\r\n\t\t&lt;%java.util.List%&gt;&lt;Object&gt; ret = new &lt;%java.util.ArrayList%&gt;&lt;&gt;();\r\n\r\n\t\tif (object instanceof &lt;%pamtram.structure.generic.Section%&gt;&lt;?, ?, ?, ?&gt;) {\r\n\t\t\tret = super.getChoiceOfValues(object).stream()\r\n\t\t\t\t\t.filter(o -&gt; o instanceof pamtram.structure.generic.Class&lt;?, ?, ?, ?&gt;)\r\n\t\t\t\t\t.map(o -&gt; (pamtram.structure.generic.Class&lt;?, ?, ?, ?&gt;) o)\r\n\t\t\t\t\t.filter(o -&gt; pamtram.util.XSDAnyContentUtil\r\n\t\t\t\t\t\t\t.getEAllReferencesIncludingVirtualAnyContentReference(o.getEClass(),\r\n\t\t\t\t\t\t\t\t\tde.tud.et.ifa.agtele.emf.connecting.AllowedReferenceType.CONTAINMENT)\r\n\t\t\t\t\t\t\t.stream()\r\n\t\t\t\t\t\t\t.anyMatch(c -&gt; c.getEReferenceType().equals(&lt;%org.eclipse.emf.ecore.EcorePackage%&gt;.Literals.EOBJECT) || c\r\n\t\t\t\t\t\t\t\t\t.getEReferenceType()\r\n\t\t\t\t\t\t\t\t\t.isSuperTypeOf(((pamtram.structure.generic.Class&lt;?, ?, ?, ?&gt;) object)\r\n\t\t\t\t\t\t\t\t\t\t\t.getEClass())))\r\n\t\t\t\t\t.filter(o -&gt; !o.getAllContainer().contains(object)).collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\n\t\t} else {\r\n\r\n\t\t\t// For normal \'Classes\', the container property is not relevant to the\r\n\t\t\t// user. If it is set, it has to point to the containing \'Class\'...\r\n\t\t\t//\r\n\t\t\tif (((&lt;%org.eclipse.emf.ecore.EObject%&gt;) object).eContainer()\r\n\t\t\t\t\t.eContainer() instanceof pamtram.structure.generic.Class&lt;?, ?, ?, ?&gt;) {\r\n\t\t\t\tret.add(((EObject) object).eContainer().eContainer());\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn ret;\r\n\r\n\t}\r\n});'"
	 * @generated
	 */
	C getContainer();

	/**
	 * Sets the value of the '{@link pamtram.structure.generic.Class#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(C value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * It is bidirectional and its opposite is '{@link pamtram.structure.generic.Attribute#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of Attribute further describing the current element.
	 * <br />
	 * Specified attributes can e.g. be equipped with additional constraints (for SourceSections) or can be set via an AttributeMapping (for TargetSections).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see pamtram.structure.generic.GenericPackage#getClass_Attributes()
	 * @see pamtram.structure.generic.Attribute#getOwningClass
	 * @model opposite="owningClass" containment="true"
	 * @generated
	 */
	EList<A> getAttributes();

	/**
	 * Returns the value of the '<em><b>All Container</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Container</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Container</em>' reference list.
	 * @see pamtram.structure.generic.GenericPackage#getClass_AllContainer()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%java.util.List%&gt;&lt;Object&gt; ret = new &lt;%java.util.ArrayList%&gt;&lt;&gt;();\r\nif(this.getContainer() != null) {\r\n\r\n\t&lt;%pamtram.structure.generic.Class%&gt;&lt;?, ?, ?, ?&gt; toCheck = this;\r\n\r\n\twhile (toCheck.getContainer() != null &amp;&amp; !ret.contains(toCheck.getContainer())) {\r\n\t\tret.add(toCheck.getContainer());\r\n\t\ttoCheck = toCheck.getContainer();\r\n\t}\r\n\t\r\n\tif(this.getContainer() instanceof &lt;%pamtram.structure.generic.Section%&gt;&lt;?, ?, ?, ?&gt;) {\t\t\t\t\r\n\t\tret.addAll(((Section&lt;?, ?, ?, ?&gt;) this.getContainer()).getAllExtend());\r\n\t\tret.addAll(((Section&lt;?, ?, ?, ?&gt;) this.getContainer()).getAllExtend().stream().flatMap(s -&gt; s.getAllContainer().stream()).collect(&lt;%java.util.stream.Collectors%&gt;.toList()));\r\n\t}\r\n}\r\n\r\nret = ret.stream().distinct().collect(Collectors.toList());\r\n\r\nreturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.CLASS__ALL_CONTAINER,\r\n\t\tret.size(), ret.toArray());'"
	 * @generated
	 */
	EList<C> getAllContainer();

	/**
	 * Returns the value of the '<em><b>Actual Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Attributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual Attributes</em>' reference list.
	 * @see pamtram.structure.generic.GenericPackage#getClass_ActualAttributes()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%java.util.List%&gt;&lt;Object&gt; ret = this.getAttributes().stream().filter(a -&gt; a instanceof pamtram.structure.generic.ActualAttribute&lt;?, ?, ?, ?&gt;).collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\n\r\nreturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.CLASS__ACTUAL_ATTRIBUTES,\r\n\t\tret.size(), ret.toArray());'"
	 * @generated
	 */
	EList<A> getActualAttributes();

	/**
	 * Returns the value of the '<em><b>Virtual Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Virtual Attributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Virtual Attributes</em>' reference list.
	 * @see pamtram.structure.generic.GenericPackage#getClass_VirtualAttributes()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%java.util.List%&gt;&lt;Object&gt; ret = this.getAttributes().stream().filter(a -&gt; a instanceof pamtram.structure.generic.VirtualAttribute&lt;?, ?, ?, ?&gt;).collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\n\r\nreturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.CLASS__ACTUAL_ATTRIBUTES,\r\n\t\tret.size(), ret.toArray());'"
	 * @generated
	 */
	EList<A> getVirtualAttributes();

	/**
	 * Returns the value of the '<em><b>Actual References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual References</em>' reference list.
	 * @see pamtram.structure.generic.GenericPackage#getClass_ActualReferences()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%java.util.List%&gt;&lt;Object&gt; ret = this.getReferences().stream().filter(a -&gt; a instanceof pamtram.structure.generic.ActualReference&lt;?, ?, ?, ?&gt;).collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\n\r\nreturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.CLASS__ACTUAL_REFERENCES,\r\n\t\tret.size(), ret.toArray());'"
	 * @generated
	 */
	EList<R> getActualReferences();

	/**
	 * Returns the value of the '<em><b>Virtual References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Virtual References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Virtual References</em>' reference list.
	 * @see pamtram.structure.generic.GenericPackage#getClass_VirtualReferences()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='&lt;%java.util.List%&gt;&lt;Object&gt; ret = this.getReferences().stream().filter(a -&gt; a instanceof pamtram.structure.generic.VirtualReference&lt;?, ?, ?, ?&gt;).collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\n\r\nreturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.CLASS__VIRTUAL_REFERENCES,\r\n\t\tret.size(), ret.toArray());'"
	 * @generated
	 */
	EList<R> getVirtualReferences();

	/**
	 * Returns the value of the '<em><b>All Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Attributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Attributes</em>' reference list.
	 * @see pamtram.structure.generic.GenericPackage#getClass_AllAttributes()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='List&lt;Object&gt; ret = new ArrayList&lt;&gt;();\n\nret.addAll(this.getAttributes());\n\nif (this instanceof Section&lt;?, ?, ?, ?&gt;) {\n\tret.addAll(((Section&lt;?, ?, ?, ?&gt;) this).getAllExtend().stream().flatMap(s -&gt; s.getAttributes().stream())\n\t\t\t.collect(&lt;%java.util.stream.Collectors%&gt;.toList()));\n}\n\nif (this.isLibraryEntry()) {\n\n\t&lt;%pamtram.structure.library.LibraryEntry%&gt; libraryEntry = (&lt;%pamtram.structure.library.LibraryEntry%&gt;) &lt;%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%&gt;.getAncestorOfKind(this,\n\t\t\t&lt;%pamtram.structure.library.LibraryPackage%&gt;.Literals.LIBRARY_ENTRY);\n\n\tif (libraryEntry != null) {\n\n\t\tret.add(libraryEntry.getId());\n\t\tret.add(libraryEntry.getClasspath());\n\t\tret.addAll(libraryEntry.getParameters().stream().filter(p -&gt; p instanceof pamtram.structure.library.AttributeParameter)\n\t\t\t\t.map(p -&gt; ((pamtram.structure.library.AttributeParameter) p).getAttribute()).collect(&lt;%java.util.stream.Collectors%&gt;.toList()));\n\t}\n}\n\nreturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.CLASS__ALL_ATTRIBUTES, ret.size(),\n\t\tret.toArray());'"
	 * @generated
	 */
	EList<A> getAllAttributes();

	/**
	 * Returns the value of the '<em><b>All References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All References</em>' reference list.
	 * @see pamtram.structure.generic.GenericPackage#getClass_AllReferences()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='List&lt;Object&gt; ret = new ArrayList&lt;&gt;();\n\nret.addAll(this.getReferences());\n\nif (this instanceof Section&lt;?, ?, ?, ?&gt;) {\n\tret.addAll(((Section&lt;?, ?, ?, ?&gt;) this).getAllExtend().stream().flatMap(s -&gt; s.getReferences().stream())\n\t\t\t.collect(&lt;%java.util.stream.Collectors%&gt;.toList()));\n}\n\nif (this.isLibraryEntry()) {\n\n\t&lt;%pamtram.structure.library.LibraryEntry%&gt; libraryEntry = (&lt;%pamtram.structure.library.LibraryEntry%&gt;) &lt;%de.tud.et.ifa.agtele.emf.AgteleEcoreUtil%&gt;.getAncestorOfKind(this,\n\t\t\t&lt;%pamtram.structure.library.LibraryPackage%&gt;.Literals.LIBRARY_ENTRY);\n\n\tif (libraryEntry != null) {\n\n\t\tret.addAll(libraryEntry.getParameters().stream().filter(p -&gt; p instanceof pamtram.structure.library.ExternalReferenceParameter)\n\t\t\t\t.map(p -&gt; ((pamtram.structure.library.ExternalReferenceParameter) p).getReference()).collect(&lt;%java.util.stream.Collectors%&gt;.toList()));\n\t}\n}\n\nreturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.CLASS__ALL_REFERENCES, ret.size(),\n\t\tret.toArray());'"
	 * @generated
	 */
	EList<R> getAllReferences();

	/**
	 * Returns the value of the '<em><b>All Concrete Extending</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Concrete Extending</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Concrete Extending</em>' reference list.
	 * @see pamtram.structure.generic.GenericPackage#getClass_AllConcreteExtending()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='@SuppressWarnings(\"unchecked\")\nList&lt;Object&gt; ret = this instanceof Section&lt;?, ?, ?, ?&gt; &amp;&amp; ((S) this).isAbstract()\n\t\t? ((S) this).getAllExtending().stream().filter(s -&gt; !s.isAbstract()).collect(&lt;%java.util.stream.Collectors%&gt;.toList())\n\t\t: &lt;%java.util.Arrays%&gt;.asList(this);\n\nreturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.CLASS__ALL_CONCRETE_EXTENDING, ret.size(),\n\t\tret.toArray());'"
	 * @generated
	 */
	EList<C> getAllConcreteExtending();

	/**
	 * Returns the value of the '<em><b>All Composite References</b></em>' reference list.
	 * The list contents are of type {@link pamtram.structure.generic.CompositeReference}&lt;S, C, R, A>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Composite References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Composite References</em>' reference list.
	 * @see pamtram.structure.generic.GenericPackage#getClass_AllCompositeReferences()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='\r\n&lt;%java.util.List%&gt;&lt;Object&gt; ret = this.getAllReferences().stream().filter(r -&gt; r instanceof &lt;%pamtram.structure.generic.CompositeReference%&gt;&lt;?, ?, ?, ?&gt;)\r\n\t\t.map(r -&gt; (CompositeReference&lt;?, ?, ?, ?&gt;) r).collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\n\r\nreturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.CLASS__ALL_COMPOSITE_REFERENCES,\r\n\t\tret.size(), ret.toArray());'"
	 * @generated
	 */
	EList<CompositeReference<S, C, R, A>> getAllCompositeReferences();

	/**
	 * Returns the value of the '<em><b>All Cross References</b></em>' reference list.
	 * The list contents are of type {@link pamtram.structure.generic.CrossReference}&lt;S, C, R, A>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Cross References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Cross References</em>' reference list.
	 * @see pamtram.structure.generic.GenericPackage#getClass_AllCrossReferences()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='\r\n&lt;%java.util.List%&gt;&lt;Object&gt; ret = this.getAllReferences().stream().filter(r -&gt; r instanceof &lt;%pamtram.structure.generic.CrossReference%&gt;&lt;?, ?, ?, ?&gt;)\r\n\t\t.map(r -&gt; (CrossReference&lt;?, ?, ?, ?&gt;) r).collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\n\r\nreturn new &lt;%org.eclipse.emf.ecore.util.EcoreEList%&gt;.UnmodifiableEList&lt;&gt;(this, &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.CLASS__ALL_CROSS_REFERENCES, ret.size(),\r\n\t\tret.toArray());'"
	 * @generated
	 */
	EList<CrossReference<S, C, R, A>> getAllCrossReferences();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" containedClassRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif (&lt;%org.eclipse.emf.ecore.util.EcoreUtil%&gt;.isAncestor(this, containedClass)\r\n\t\t|| this.getContainingSection().getAllExtend().stream().anyMatch(c -&gt; c.isContainerFor(containedClass))\r\n\t\t|| containedClass.getContainingSection().getAllExtend().stream()\r\n\t\t\t\t.anyMatch(c -&gt; this.isContainerFor((C) c))) {\r\n\treturn true;\r\n}\r\n\r\nC container = containedClass.getContainingSection().getContainer();\r\n\r\n// this means that we have reached the top level container for the \'containedClass\'\r\nif (container == null) {\r\n\treturn false;\r\n}\r\n\r\n// Prevent stack overflow in case of modeling error\r\n//\r\nif (EcoreUtil.isAncestor(containedClass, container)) {\r\n\treturn false;\r\n}\r\n\r\n// this was not the container, so iterate up in the containment hierarchy\r\nreturn this.isContainerFor(container);\r\n'"
	 * @generated
	 */
	boolean isContainerFor(C containedClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" containerClassRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n// recursively collect all classes that are referenced by containment references and check if any matches this\r\n// class\r\n//\r\nreturn containerClass.getAllReferences().stream()\r\n\t\t.filter(r -&gt; r instanceof &lt;%pamtram.structure.generic.ActualReference%&gt;&lt;?, ?, ?, ?&gt;\r\n\t\t\t\t&amp;&amp; ((ActualReference&lt;?, ?, ?, ?&gt;) r).getEReference().isContainment())\r\n\t\t.flatMap(r -&gt; r.getValuesGeneric().stream()).anyMatch(\r\n\t\t\t\tc -&gt; c.equals(this)\r\n\t\t\t\t\t\t|| c instanceof &lt;%pamtram.structure.generic.Section%&gt;&lt;?, ?, ?, ?&gt;\r\n\t\t\t\t\t\t\t\t&amp;&amp; ((Section&lt;?, ?, ?, ?&gt;) c).getAllExtending().contains(this)\r\n\t\t\t\t\t\t|| this.isContainedIn(c));'"
	 * @generated
	 */
	boolean isContainedIn(C containerClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this.eContainer() instanceof CompositeReference&lt;?,?,?,?&gt;) {\r\n\treturn (CompositeReference&lt;S,C,R,A&gt;) this.eContainer();\r\n} else {\r\n\treturn null;\r\n}'"
	 * @generated
	 */
	CompositeReference<S, C, R, A> getOwningContainmentReference();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" referencingClassRequired="true" referencedClassesMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if(referencedClasses == null) {\r\n\treferencedClasses = new BasicEList&lt;&gt;();\r\n}\r\nBasicEList&lt;C&gt; classes = new BasicEList&lt;&gt;();\r\n\r\n// collect all classes that are referenced\r\nfor (R ref : referencingClass.getReferences()) {\r\n\r\n\tif(ref instanceof ContainmentReference&lt;?,?,?,?&gt;){\r\n\t\tclasses.addAll(((ContainmentReference&lt;S,C,R,A&gt;) ref).getValue());\r\n\t} else if(ref instanceof MetaModelSectionReference) {\r\n\t\tclasses.addAll((Collection&lt;? extends C&gt;) ((MetaModelSectionReference) ref).getValue());\r\n\t} else if(ref instanceof NonContainmentReference){\r\n\t\tclasses.addAll(((NonContainmentReference&lt;S,C,R,A&gt;) ref).getValue());\r\n\t}\r\n}\r\n\r\n// recursively iterate over all referenced classes\r\nfor (C clazz : classes) {\r\n\tif(clazz.equals(this) || isReferencedBy(clazz, referencedClasses)) {\r\n\t\treturn true;\r\n\t} else {\r\n\t\tif(!referencedClasses.contains(clazz)) {\r\n\t\t\treferencedClasses.add(clazz);\r\n\t\t}\r\n\t}\r\n}\r\n\r\nreturn false;'"
	 * @generated
	 */
	boolean isReferencedBy(C referencingClass, EList<C> referencedClasses);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif (this == this.getContainingSection() || this.getEClass() == null\r\n\t\t|| !(this.eContainer() instanceof &lt;%pamtram.structure.generic.ActualReference%&gt;&lt;?, ?, ?, ?&gt;)) {\r\n\treturn true;\r\n}\r\n\r\nActualReference&lt;?, ?, ?, ?&gt; parentReference = (ActualReference&lt;?, ?, ?, ?&gt;) this.eContainer();\r\n\r\nif (parentReference.getEReference() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = &lt;%org.eclipse.emf.ecore.EcorePackage%&gt;.Literals.EOBJECT.equals(parentReference.getEReference().getEReferenceType())\r\n\t\t|| parentReference.getEReference().getEReferenceType().isSuperTypeOf(this.getEClass());\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"The eClass \'\" + this.eClass().getName()\r\n\t\t\t+ \"\' is not allowed by the containing reference!\";\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%pamtram.structure.generic.util.GenericValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\tGenericValidator.CLASS__VALIDATE_ECLASS_MATCHES_PARENT_EREFERENCE, errorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.CLASS__ECLASS }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateEClassMatchesParentEReference(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nif(this == this.getContainingSection() || this.getEClass() == null || !(this.eContainer() instanceof ActualReference&lt;?, ?, ?, ?&gt;)) {\r\n\treturn true;\r\n}\r\n\r\n&lt;%pamtram.structure.generic.ActualReference%&gt;&lt;?, ?, ?, ?&gt; parentReference = (ActualReference&lt;?, ?, ?, ?&gt;) this.eContainer();\r\n\r\nif(parentReference.getEReference() == null) {\r\n\treturn true;\r\n}\r\n\r\nboolean result = !(this.cardinality != &lt;%pamtram.structure.generic.CardinalityType%&gt;.ONE &amp;&amp; parentReference.getEReference().getUpperBound() == 1 &amp;&amp; parentReference.getEReference().getLowerBound() == 1);\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"The cardinality of a Class must be specified as \'CardinalityType::ONE\' when the upper and lower bound of the containing Reference is \'1\'!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR,\r\n\t\t\t&lt;%pamtram.structure.generic.util.GenericValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\t\tGenericValidator.CLASS__VALIDATE_CARDINALITY_IS_VALID,\r\n\t\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.CLASS__CARDINALITY }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateCardinalityIsValid(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\nboolean result;\r\nString errorMessage = \"\";\r\n\r\nif (this.getContainer() == null) {\r\n\t// nothing specified -&gt; no problem as the \'container\' is an optional info\r\n\t//\r\n\tresult = true;\r\n} else if (this instanceof &lt;%pamtram.structure.generic.Section%&gt;&lt;?, ?, ?, ?&gt;) {\r\n\t// For Sections, the container must point to a Class that can theoretically (according to the metamodel) act\r\n\t// as container\r\n\t//\r\n\tresult = this.getEClass() == null || this.getContainer().getEClass() == null\r\n\t\t\t|| pamtram.util.XSDAnyContentUtil\r\n\t\t\t\t\t.getEAllReferencesIncludingVirtualAnyContentReference(this.getContainer().getEClass(),\r\n\t\t\t\t\t\t\t&lt;%de.tud.et.ifa.agtele.emf.connecting.AllowedReferenceType%&gt;.CONTAINMENT)\r\n\t\t\t\t\t.stream().map(org.eclipse.emf.ecore.EReference::getEReferenceType).anyMatch(\r\n\t\t\t\t\t\t\te -&gt; e.equals(&lt;%org.eclipse.emf.ecore.EcorePackage%&gt;.Literals.EOBJECT) || e.isSuperTypeOf(this.getEClass()));\r\n\terrorMessage = \"The \'container\' reference must point to a Class whose type (&lt;%org.eclipse.emf.ecore.EClass%&gt;) owns a suitable containment reference!\";\r\n} else {\r\n\t// For normal Class, the container must point to a the containing Class\r\n\t//\r\n\tresult = this.getContainer().equals(this.eContainer().eContainer());\r\n\terrorMessage = \"The \'container\' refrence must point to the containing Class!\";\r\n}\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%pamtram.structure.generic.util.GenericValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\tGenericValidator.CLASS__VALIDATE_CONTAINER_IS_VALID, errorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.CLASS__CONTAINER }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateContainerIsValid(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean result = !this.getAllContainer().contains(this);\r\n\r\nif (!result &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"A Class must not specify itself as container (neither directly nor indirectly)!\";\r\n\r\n\tdiagnostics.add(new &lt;%org.eclipse.emf.common.util.BasicDiagnostic%&gt;\r\n\t\t\t(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, \r\n\t\t\t&lt;%pamtram.structure.generic.util.GenericValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\t\tGenericValidator.CLASS__VALIDATE_NOT_SELF_CONTAINER, \r\n\t\t\t\terrorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.CLASS__CONTAINER }));\r\n\r\n}\r\n\r\nreturn result;'"
	 * @generated
	 */
	boolean validateNotSelfContainer(DiagnosticChain diagnostics, Map<?, ?> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n&lt;%java.util.List%&gt;&lt;&lt;%org.eclipse.emf.ecore.EReference%&gt;&gt; actualCompositeReferences = this.getActualReferences().stream()\r\n\t\t.filter(r -&gt; r instanceof &lt;%pamtram.structure.generic.CompositeReference%&gt;&lt;?, ?, ?, ?&gt;)\r\n\t\t.map(r -&gt; ((&lt;%pamtram.structure.generic.ActualReference%&gt;&lt;?, ?, ?, ?&gt;) r).getEReference()).collect(&lt;%java.util.stream.Collectors%&gt;.toList());\r\n\r\nboolean noCompositeDuplicates = actualCompositeReferences.size() == new &lt;%java.util.HashSet%&gt;&lt;&gt;(actualCompositeReferences)\r\n\t\t.size();\r\n\r\nif (!noCompositeDuplicates &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"A Class must not specify two CompositeReferences that represent the same EReference!\";\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(&lt;%org.eclipse.emf.common.util.Diagnostic%&gt;.ERROR, &lt;%pamtram.structure.generic.util.GenericValidator%&gt;.DIAGNOSTIC_SOURCE,\r\n\t\t\tGenericValidator.CLASS__VALIDATE_ONLY_COMPLEMENTING_ACTUAL_REFERENCES, errorMessage,\r\n\t\t\tnew Object[] { this, &lt;%pamtram.structure.generic.GenericPackage%&gt;.Literals.CLASS__REFERENCES }));\r\n\r\n\treturn false;\r\n}\r\n\r\nList&lt;EReference&gt; actualCrossReferences = this.getActualReferences().stream()\r\n\t\t.filter(r -&gt; r instanceof &lt;%pamtram.structure.generic.CrossReference%&gt;&lt;?, ?, ?, ?&gt;)\r\n\t\t.map(r -&gt; ((ActualReference&lt;?, ?, ?, ?&gt;) r).getEReference()).collect(Collectors.toList());\r\n\r\nboolean noCrossDuplicates = actualCrossReferences.size() == new HashSet&lt;&gt;(actualCrossReferences).size();\r\n\r\nif (!noCrossDuplicates &amp;&amp; diagnostics != null) {\r\n\r\n\tString errorMessage = \"A Class must not specify two CrossReferences that represent the same EReference!\";\r\n\r\n\tdiagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, GenericValidator.DIAGNOSTIC_SOURCE,\r\n\t\t\tGenericValidator.CLASS__VALIDATE_ONLY_COMPLEMENTING_ACTUAL_REFERENCES, errorMessage,\r\n\t\t\tnew Object[] { this, GenericPackage.Literals.CLASS__REFERENCES }));\r\n\r\n\treturn false;\r\n}\r\n\r\nreturn true;'"
	 * @generated
	 */
	boolean validateOnlyComplementingActualReferences(DiagnosticChain diagnostics, Map<?, ?> context);

} // Class
