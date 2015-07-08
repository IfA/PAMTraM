/**
 */
package pamtram.metamodel;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pamtram.metamodel.Class#getEClass <em>EClass</em>}</li>
 *   <li>{@link pamtram.metamodel.Class#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link pamtram.metamodel.Class#getReferences <em>References</em>}</li>
 *   <li>{@link pamtram.metamodel.Class#getContainer <em>Container</em>}</li>
 *   <li>{@link pamtram.metamodel.Class#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see pamtram.metamodel.MetamodelPackage#getClass_()
 * @model abstract="true"
 * @generated
 */
public interface Class<C extends Class<C, R, A>, R extends Reference<C, R, A>, A extends Attribute<C, R, A>> extends MetaModelElement<C, R, A> {
	/**
	 * Returns the value of the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EClass</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EClass</em>' reference.
	 * @see #setEClass(EClass)
	 * @see pamtram.metamodel.MetamodelPackage#getClass_EClass()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!Class{C,R,A}!eClass'"
	 * @generated
	 */
	EClass getEClass();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.Class#getEClass <em>EClass</em>}' reference.
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
	 * The literals are from the enumeration {@link pamtram.metamodel.CardinalityType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cardinality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cardinality</em>' attribute.
	 * @see pamtram.metamodel.CardinalityType
	 * @see #setCardinality(CardinalityType)
	 * @see pamtram.metamodel.MetamodelPackage#getClass_Cardinality()
	 * @model default="ONE" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!Class{C,R,A}!cardinality'"
	 * @generated
	 */
	CardinalityType getCardinality();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.Class#getCardinality <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cardinality</em>' attribute.
	 * @see pamtram.metamodel.CardinalityType
	 * @see #getCardinality()
	 * @generated
	 */
	void setCardinality(CardinalityType value);

	/**
	 * Returns the value of the '<em><b>References</b></em>' containment reference list.
	 * It is bidirectional and its opposite is '{@link pamtram.metamodel.Reference#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getClass_References()
	 * @see pamtram.metamodel.Reference#getOwningClass
	 * @model opposite="owningClass" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!Class{C,R,A}!references'"
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
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #setContainer(Class)
	 * @see pamtram.metamodel.MetamodelPackage#getClass_Container()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!Class{C,R,A}!container'"
	 * @generated
	 */
	C getContainer();

	/**
	 * Sets the value of the '{@link pamtram.metamodel.Class#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(C value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * It is bidirectional and its opposite is '{@link pamtram.metamodel.Attribute#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see pamtram.metamodel.MetamodelPackage#getClass_Attributes()
	 * @see pamtram.metamodel.Attribute#getOwningClass
	 * @model opposite="owningClass" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://mfreund.de/pamtram/metamodel!Class{C,R,A}!attributes'"
	 * @generated
	 */
	EList<A> getAttributes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" containedClassRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='C container = containedClass.getContainer();\r\n\t\t\r\n// this means that we have reached the top level container for the \'containedClass\'\r\nif(container == null) {\r\n\treturn false;\r\n// this is the container\r\n} else if(this.equals(container)) {\r\n\treturn true;\r\n// this was not the container, so iterate up in the containment hierarchy\r\n} else {\r\n\treturn isContainerFor(container);\r\n}'"
	 * @generated
	 */
	boolean isContainerFor(C containedClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.equals(this.getContainingSection());'"
	 * @generated
	 */
	boolean isSection();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" containerClassRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<C> containedClasses = new BasicEList<>();\r\n\r\n// collect all classes that are referenced by containment references\r\nfor (R ref : containerClass.getReferences()) {\r\n\tif(!(ref.getEReference().isContainment())) {\r\n\t\tcontinue;\r\n\t}\r\n\tif(ref instanceof ContainmentReference<?,?,?>){\r\n\t\tcontainedClasses.addAll(((ContainmentReference<C,R,A>) ref).getValue());\r\n\t} else if(ref instanceof MetaModelSectionReference) {\r\n\t\tcontainedClasses.addAll((Collection<? extends C>) ((MetaModelSectionReference) ref).getValue());\r\n\t}\r\n}\r\n\t\r\n// recursively iterate over all contained classes\r\nboolean found = false;\r\nfor (C containedClass : containedClasses) {\r\n\tif(containedClass.equals(this) || isContainedIn(containedClass)) {\r\n\t\tfound = true;\r\n\t\tbreak;\r\n\t}\r\n}\r\n\r\nreturn found;'"
	 * @generated
	 */
	boolean isContainedIn(C containerClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if(this.eContainer() instanceof ContainmentReference<?,?,?>) {\r\n\treturn (ContainmentReference<C,R,A>) this.eContainer();\r\n} else {\r\n\treturn null;\r\n}'"
	 * @generated
	 */
	ContainmentReference<C, R, A> getOwningContainmentReference();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv containerIsValid:\n *   let severity : Integer[1] = \'Class::containerIsValid\'.getSeverity()\n *   in\n *     if severity <= 0\n *     then true\n *     else\n *       let\n *         status : OclAny[1] = if self.isSection() or self.container = null\n *         then true\n *         else self.container = self.oclContainer().oclContainer()\n *         endif\n *       in\n *         \'Class::containerIsValid\'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)\n *     endif\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> severity_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%>.INSTANCE.evaluate(evaluator, <%pamtram.metamodel.MetamodelTables%>.STR_Class_c_c_containerIsValid));\nfinal /*@NonInvalid\052/ boolean le = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, severity_0, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue());\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n    symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n}\nelse {\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\n    try {\n        /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_isSection;\n        try {\n            final /*@Thrown\052/ boolean isSection = this.isSection();\n            CAUGHT_isSection = isSection;\n        }\n        catch (<%java.lang.Exception%> e) {\n            CAUGHT_isSection = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n        }\n        /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_eq;\n        try {\n            final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> container = this.getContainer();\n            final /*@Thrown\052/ boolean eq = container == null;\n            CAUGHT_eq = eq;\n        }\n        catch (<%java.lang.Exception%> e) {\n            CAUGHT_eq = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n        }\n        final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> or = <%org.eclipse.ocl.pivot.library.logical.BooleanOrOperation%>.INSTANCE.evaluate(CAUGHT_isSection, CAUGHT_eq);\n        if (or == null) {\n            throw new <%org.eclipse.ocl.pivot.values.InvalidValueException%>(\"Null if condition\");\n        }\n        /*@Thrown\052/ boolean status;\n        if (or) {\n            status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n        }\n        else {\n            final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> container_0 = this.getContainer();\n            final /*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, this);\n            final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> oclContainer_0 = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, oclContainer);\n            final /*@Thrown\052/ boolean eq_0 = (container_0 != null) ? container_0.equals(oclContainer_0) : (oclContainer_0 == null);\n            status = eq_0;\n        }\n        CAUGHT_status = status;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.metamodel.MetamodelTables%>.STR_Class_c_c_containerIsValid, this, null, diagnostics, context, null, severity_0, CAUGHT_status, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue());\n    symbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean containerIsValid(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv cardinalityIsValid:\n *   let severity : Integer[1] = \'Class::cardinalityIsValid\'.getSeverity()\n *   in\n *     if severity <= 0\n *     then true\n *     else\n *       let\n *         status : OclAny[?] = if self <> self.getContainingSection()\n *         then\n *           not (self.cardinality <> CardinalityType::ONE and\n *             self.oclContainer()\n *             .oclAsType(Reference(C, R, A))\n *             .eReference.oclAsType(ecore::EReference).upperBound <= 1\n *           )\n *         else true\n *         endif\n *       in\n *         \'Class::cardinalityIsValid\'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)\n *     endif\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> severity_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%>.INSTANCE.evaluate(evaluator, <%pamtram.metamodel.MetamodelTables%>.STR_Class_c_c_cardinalityIsValid));\nfinal /*@NonInvalid\052/ boolean le = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, severity_0, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue());\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n    symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n}\nelse {\n    /*@Nullable\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\n    try {\n        final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> getContainingSection = ((<%pamtram.metamodel.MetaModelElement%>)this).getContainingSection();\n        final /*@Thrown\052/ boolean ne = !this.equals(getContainingSection);\n        /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> status;\n        if (ne) {\n            /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_ne_0;\n            try {\n                final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.common.util.Enumerator%> cardinality = this.getCardinality();\n                final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.ids.EnumerationLiteralId%> BOXED_cardinality = <%pamtram.metamodel.MetamodelTables%>.ENUMid_CardinalityType.getEnumerationLiteralId(<%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(cardinality.getName()));\n                final /*@Thrown\052/ boolean ne_0 = BOXED_cardinality != <%pamtram.metamodel.MetamodelTables%>.ELITid_ONE;\n                CAUGHT_ne_0 = ne_0;\n            }\n            catch (<%java.lang.Exception%> e) {\n                CAUGHT_ne_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n            }\n            /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_le_0;\n            try {\n                final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_ecore_c_c_EReference_0 = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_EReference, null);\n                final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_Reference_o_C_44_R_44_A_e_0 = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_Reference, null);\n                final /*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, this);\n                final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.Reference%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.Reference%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_metamodel_c_c_Reference_o_C_44_R_44_A_e_0));\n                final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EReference%> eReference = oclAsType.getEReference();\n                final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EReference%> oclAsType_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.emf.ecore.EReference%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, eReference, TYP_ecore_c_c_EReference_0));\n                final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> upperBound = oclAsType_0.getUpperBound();\n                final /*@Nullable\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> BOXED_upperBound = upperBound == null ? null : <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.integerValueOf(upperBound);\n                final /*@Thrown\052/ boolean le_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, BOXED_upperBound, <%pamtram.metamodel.MetamodelTables%>.INT_1).booleanValue());\n                CAUGHT_le_0 = le_0;\n            }\n            catch (<%java.lang.Exception%> e) {\n                CAUGHT_le_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n            }\n            final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> and = <%org.eclipse.ocl.pivot.library.logical.BooleanAndOperation%>.INSTANCE.evaluate(CAUGHT_ne_0, CAUGHT_le_0);\n            final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> not = <%org.eclipse.ocl.pivot.library.logical.BooleanNotOperation%>.INSTANCE.evaluate(and);\n            status = not;\n        }\n        else {\n            status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n        }\n        CAUGHT_status = status;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.metamodel.MetamodelTables%>.STR_Class_c_c_cardinalityIsValid, this, null, diagnostics, context, null, severity_0, CAUGHT_status, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue());\n    symbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean cardinalityIsValid(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv eClassMatchesParentEReference:\n *   let\n *     severity : Integer[1] = \'Class::eClassMatchesParentEReference\'.getSeverity()\n *   in\n *     if severity <= 0\n *     then true\n *     else\n *       let\n *         status : OclAny[?] = if self <> self.getContainingSection()\n *         then\n *           self.oclContainer()\n *           .oclAsType(Reference(C, R, A))\n *           .eReference.oclAsType(ecore::EReference)\n *           .eReferenceType.isSuperTypeOf(\n *             self.eClass.oclAsType(ecore::EClass))\n *         else true\n *         endif\n *       in\n *         \'Class::eClassMatchesParentEReference\'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)\n *     endif\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> severity_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%>.INSTANCE.evaluate(evaluator, <%pamtram.metamodel.MetamodelTables%>.STR_Class_c_c_eClassMatchesParentEReference));\nfinal /*@NonInvalid\052/ boolean le = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, severity_0, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue());\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n    symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n}\nelse {\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\n    try {\n        final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.Object%> getContainingSection = ((<%pamtram.metamodel.MetaModelElement%>)this).getContainingSection();\n        final /*@Thrown\052/ boolean ne = !this.equals(getContainingSection);\n        /*@Thrown\052/ boolean status;\n        if (ne) {\n            final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_ecore_c_c_EClass = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_EClass, null);\n            final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_ecore_c_c_EReference = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_EReference, null);\n            final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_pamtram_c_c_metamodel_c_c_Reference_o_C_44_R_44_A_e = idResolver.getClass(<%pamtram.metamodel.MetamodelTables%>.CLSSid_Reference, null);\n            final /*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.Object%> oclContainer = <%org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation%>.INSTANCE.evaluate(evaluator, this);\n            final /*@NonNull\052/ /*@Thrown\052/ <%pamtram.metamodel.Reference%> oclAsType = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%pamtram.metamodel.Reference%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, oclContainer, TYP_pamtram_c_c_metamodel_c_c_Reference_o_C_44_R_44_A_e));\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EReference%> eReference = oclAsType.getEReference();\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EReference%> oclAsType_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.emf.ecore.EReference%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, eReference, TYP_ecore_c_c_EReference));\n            @SuppressWarnings(\"null\")\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> eReferenceType = oclAsType_0.getEReferenceType();\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> eClass = this.getEClass();\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.emf.ecore.EClass%> oclAsType_1 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState((<%org.eclipse.emf.ecore.EClass%>)<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation%>.INSTANCE.evaluate(evaluator, eClass, TYP_ecore_c_c_EClass));\n            final /*@Thrown\052/ boolean isSuperTypeOf = eReferenceType.isSuperTypeOf(oclAsType_1);\n            status = isSuperTypeOf;\n        }\n        else {\n            status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n        }\n        CAUGHT_status = status;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%pamtram.metamodel.MetamodelTables%>.STR_Class_c_c_eClassMatchesParentEReference, this, null, diagnostics, context, null, severity_0, CAUGHT_status, <%pamtram.metamodel.MetamodelTables%>.INT_0).booleanValue());\n    symbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean eClassMatchesParentEReference(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Class
