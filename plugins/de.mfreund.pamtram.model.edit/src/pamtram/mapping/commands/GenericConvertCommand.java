package pamtram.mapping.commands;

import java.util.Collection;
import java.util.Collections;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * A generic command that converts an instance of a source type to an instance of the target type.
 * 
 * Therefore, an implementation of the interface 'IConverter' has to be provided that does the conversion when
 * the command is invoked.
 * 
 * @author mfreund
 *
 * @param <SourceType> the type of the object to be converted
 * @param <TargetType> the type of the object to be created during the conversion
 */
public class GenericConvertCommand<SourceType extends EObject, TargetType extends EObject> 
	extends AbstractOverrideableCommand {

	/**
	 * This caches the label.
	 */
	protected static final String LABEL = "ConvertCommand";
	/**
	 * This caches the description.
	 */
	protected static final String DESCRIPTION = "ConvertCommand";
	/**
	 * This is the owner object upon which the command will act.
	 * It could be null, in the case that we are dealing with an {@link org.eclipse.emf.common.util.EList}.
	 */
	protected EObject owner;
	/**
	 * This is the feature of the owner object upon the command will act.
	 * It could be null, in the case that we are dealing with an {@link org.eclipse.emf.common.util.EList}.
	 */
	protected EStructuralFeature feature;
	/**
	 * This is the source type to be converted.
	 */
	protected SourceType source;
	/**
	 * This is the target type to be created.
	 */
	protected TargetType target;
	/**
	 * This is the converter used to convert the source to the target.
	 */
	protected IConverter<SourceType, TargetType> converter;
	/**
	 * This is the index at which to reinsert the replaced object during an undo so as to achieve the original list order.
	 */ 
	protected int index;
	/**
	 * The is the value returned by {@link Command#getAffectedObjects}.
	 * The affected objects are different after an execute than after an undo, so we record it.
	 */
	protected Collection<?> affectedObjects;
	
	/**
	 * This constructs an instance of the generic command to convert an instance of a source type to an 
	 * instance of the target type.
	 * 
	 * The actual conversion is performed by an instance of 'IConverter' that is called when the command is invoked.
	 * 
	 * @param domain the editing domain that the command operated on
	 * @param owner the owner of the object to be converted (will probably be 'source.eContainer()')
	 * @param feature the feature that holds the source object (and after the conversion the target object) 
	 * @param source the source object to be converted
	 * @param converter the converter used to transform the source object during the execution of the command
	 */
	public GenericConvertCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, SourceType source, IConverter<SourceType, TargetType> converter)
	{
	  super(domain, LABEL, DESCRIPTION);
	  // Initialize all the fields from the command parameter.
	  //
	  this.owner = owner;
	  this.feature = feature;
	  this.source = source;
	  this.converter = converter;
	}
	/**
	 * This returns the owner object upon which the command will act.
	 * It could be null, in the case that we are dealing with an {@link org.eclipse.emf.common.util.EList}.
	 */
	public EObject getOwner()
	{
	  return owner;
	}
	/**
	 * This returns the feature of the owner object upon the command will act.
	 * It could be null, in the case that we are dealing with an {@link org.eclipse.emf.common.util.EList}.
	 */
	public EStructuralFeature getFeature()
	{
	  return feature;
	}
	/**
	 * This returns the source type to be converted.
	 */
	public SourceType getSource()
	{
	  return source;
	}
	/**
	 * This returns the target type to be created.
	 */
	public TargetType getTarget()
	{
	  return target;
	}
	/**
	 * This returns the index at which to reinsert the replace objects during an undo so as to achieve the original list order.
	 */ 
	public int getIndex()
	{
		return index;
	}
	@Override
	protected boolean prepare() 
	{
	  return true;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void doExecute() 
	{

		if(feature.isMany()) {
			index = ((EList)(owner.eGet(feature))).indexOf(source);
		}
		
		target = converter.convert(source);
				
		if(feature.isMany()) {
			((EList)(owner.eGet(feature))).remove(source);
			((EList)(owner.eGet(feature))).add(index, target);
		} else {
			owner.eSet(feature, target);
		}

		affectedObjects = Collections.singleton(target);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void doUndo() 
	{
		if(feature.isMany()) {
			((EList)(owner.eGet(feature))).remove(target);
			((EList)(owner.eGet(feature))).add(index, source);
		} else {
			owner.eSet(feature, source);
		}

		affectedObjects = Collections.singleton(source);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void doRedo()
	{
		if(feature.isMany()) {
			((EList)(owner.eGet(feature))).remove(source);
			((EList)(owner.eGet(feature))).add(index, target);
		} else {
			owner.eSet(feature, target);
		}

		affectedObjects = Collections.singleton(target);
	}
	@Override
	public Collection<?> doGetResult()
	{
	  return affectedObjects;
	}
	@Override
	public Collection<?> doGetAffectedObjects()
	{
	  return affectedObjects;
	}
	/**
	 * This gives an abbreviated name using this object's own class' name, without package qualification,
	 * followed by a space separated list of <tt>field:value</tt> pairs.
	 */
	@Override
	public String toString()
	{
	  StringBuffer result = new StringBuffer(super.toString());
	  result.append(" (owner: " + owner + ")");
	  result.append(" (feature: " + feature + ")");
	  result.append(" (source: " + source + ")");
	  result.append(" (target: " + target + ")");
	  result.append(" (affectedObjects:" + affectedObjects + ")");
	  return result.toString();
	}
	
	/**
	 * Interface that needs to be implemented to convert a source element to a target element.
	 * 
	 * @author mfreund
	 *
	 * @param <SourceType>
	 * @param <TargetType>
	 */
	public interface IConverter<SourceType extends EObject, TargetType extends EObject> {
		
		/**
		 * Converts an instance of the SourceType to an instance of the TargetType.
		 * 
		 * Attention: When implementing this interface, make sure that 'EcoreUtil.copyAll()' is
		 * used to copy child elements (referenced via a containment reference). Otherwise, 
		 * 'undo()' does not work correctly (the child elements are lost).
		 * 
		 * @param source instance of the source type
		 * @return instance of the target type
		 */
		public TargetType convert(SourceType source);
	}
	
}
