/*
 * Copyright (c) 2021-2021. Bernard Bou.
 */

package org.oewntk.ser.out;

import org.oewntk.model.CoreModel;
import org.oewntk.model.Serialize;

import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;

/**
 * Main class that serializes the core model.
 *
 * @author Bernard Bou
 * @see "https://sqlunet.sourceforge.net/schema.html"
 */
public class CoreModelConsumer implements Consumer<CoreModel>
{
	/**
	 * Output dir
	 */
	protected final File file;

	/**
	 * Constructor
	 *
	 * @param file output file
	 */
	public CoreModelConsumer(final File file)
	{
		this.file = file;
	}

	@Override
	public void accept(final CoreModel model)
	{
		Tracing.psInfo.printf("[CoreModel] %s%n", model.getSource());

		try
		{
			Serialize.serializeCoreModel(model, file);
		}
		catch (IOException e)
		{
			e.printStackTrace(Tracing.psErr);
		}
	}
}
