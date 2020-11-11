package com.icaballero.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icaballero.springboot.form.app.services.PaisService;

@Component
public class PaisPropertyEditors extends PropertyEditorSupport {

	@Autowired
	private PaisService paisService;

	@Override
	public void setAsText(String idString) throws IllegalArgumentException {

		if (idString != null && idString.length() > 0) {

			try {

				Integer id = Integer.parseInt(idString);
				this.setValue(paisService.obtenerPorId(id));

			} catch (NumberFormatException e) {
				setValue(null);
			}

		} else {
			setValue(null);
		}

	}

}
