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
package de.mfreund.gentrans.transformation.resolving.wizards;

import java.util.Optional;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import de.tud.et.ifa.agtele.ui.listeners.SelectionListener2;

/**
 * A simple {@link AbstractDialog} that allows the user to enter a single value.
 *
 * @author mfreund
 */
public class ValueSpecificationDialog extends AbstractDialog {

	/**
	 * The value entered by the user.
	 */
	protected String retValue;

	/**
	 * The data type of the value to enter.
	 */
	protected EDataType dataType;

	/**
	 * Create the dialog.
	 *
	 * @param message
	 *            The message that shall be displayed in the dialog.
	 * @param dataType
	 *            The data type of the value to enter.
	 * @param enhanceMappingModelListener
	 *            An optional {@link SelectionListener2} that will be called when the <em>EnhanceMappingModelButton</em>
	 *            is clicked. If no listener is given, the button will be grayed out.
	 */
	public ValueSpecificationDialog(String message, EDataType dataType,
			Optional<SelectionListener2> enhanceMappingModelListener) {

		super(message, enhanceMappingModelListener);
		this.dataType = dataType;
	}

	@Override
	protected void createInnerContents(Composite container) {

		Group valueGroup = new Group(container, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).minSize(200, 200).applyTo(valueGroup);
		valueGroup.setText("Value (DataType: '" + this.dataType.getName() + "'):");
		GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(valueGroup);

		Text textValue = new Text(valueGroup, SWT.BORDER);
		textValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textValue.addModifyListener((ModifyEvent e) -> this.retValue = textValue.getText());

	}

	/**
	 * Get the value specified by the user after the dialog has finished.
	 *
	 * @return The specified value as String.
	 */
	public String getValue() {

		return this.retValue;
	}

}
