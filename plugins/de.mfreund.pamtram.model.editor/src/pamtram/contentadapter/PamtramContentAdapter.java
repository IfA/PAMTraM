/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package pamtram.contentadapter;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;

import pamtram.presentation.PamtramEditor;

/**
 * A content adapter that listens for changes in a pamtram instance and tries to
 * automatically determine attribute values or reference targets based on the
 * changed object.
 *
 * @author mfreund
 */
public class PamtramContentAdapter extends EContentAdapter {

	// The editor that this content adapter works on.
	private PamtramEditor editor = null;

	/**
	 * Returns the {@link PamtramEditor} that this content adapter works on.
	 *
	 * @return the {@link #editor}
	 */
	public PamtramEditor getEditor() {
		return this.editor;
	}

	/**
	 * A list of EContentAdapters that act as children of this adapter and will
	 * be notified of any changes when this adapter is notified. With this
	 * structure, a better separation should be possible but we can still manage
	 * to work with one single content adapter for everything.
	 */
	ArrayList<PamtramChildContentAdapter> subAdapters = new ArrayList<>();

	/**
	 * Constructor.
	 *
	 * @param editor
	 *            The editor that this adapter works on.
	 */
	public PamtramContentAdapter(PamtramEditor editor) {

		this.editor = editor;

		// populate the list of child content adapters
		this.subAdapters.add(this.nameSettingAdapter);

	}

	@Override
	public void notifyChanged(Notification notification) {

		if (notification.getEventType() == Notification.REMOVING_ADAPTER && notification.getOldValue().equals(this)) {
			// this adapter is being disposed, so do not forward this
			// notification
			return;
		}

		// notify every child adapter
		for (EContentAdapter eContentAdapter : this.subAdapters) {
			eContentAdapter.notifyChanged(notification);
		}
	}

	/**
	 * A content adapter that will automatically set/change names of elements
	 * when an important structural feature changes.
	 */
	final NameSettingAdapter nameSettingAdapter = new NameSettingAdapter(this);

	/**
	 * This adds a new {@link PamtramChildContentAdapter} that will get
	 * notified.
	 * 
	 * @param subAdapter
	 *            The {@link PamtramChildContentAdapter} to be added.
	 */
	public void addSubAdapter(PamtramChildContentAdapter subAdapter) {
		this.subAdapters.add(subAdapter);
	}

	/**
	 * This removes an existing {@link PamtramChildContentAdapter} so that it
	 * will not be notified any more.
	 * 
	 * @param subAdapter
	 *            The {@link PamtramChildContentAdapter} to be removed.
	 */
	public void removeSubAdapter(PamtramChildContentAdapter subAdapter) {
		this.subAdapters.remove(subAdapter);
	}
}
