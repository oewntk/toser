/*
 * Copyright (c) 2021-2021. Bernard Bou.
 */

package org.oewntk.ser.out;

import org.oewntk.model.Model;
import org.oewntk.model.Serialize;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Main class that serializes the model
 *
 * @author Bernard Bou
 */
public class ModelConsumer implements Consumer<Model>
{
	/**
	 * Output file
	 */
	private final File file;

	/**
	 * Constructor
	 *
	 * @param outDir output directory
	 */
	public ModelConsumer(File outDir)
	{
		this.file = outDir;
	}

	@Override
	public void accept(final Model model)
	{
		Tracing.psInfo.printf("[Model] %s%n", Arrays.toString(model.getSources()));

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
