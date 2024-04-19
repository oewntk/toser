/*
 * Copyright (c) 2021-2021. Bernard Bou.
 */
package org.oewntk.ser.out

import org.oewntk.model.CoreModel
import org.oewntk.model.Serialize.serializeCoreModel
import java.io.File
import java.io.IOException
import java.util.function.Consumer

/**
 * Main class that serializes the core model.
 *
 * @property file output file
 * @author Bernard Bou
 */
class CoreModelConsumer(private val file: File) : Consumer<CoreModel> {

	override fun accept(model: CoreModel) {
		Tracing.psInfo.printf("[CoreModel] %s%n", model.source)
		try {
			serializeCoreModel(model, file)
		} catch (e: IOException) {
			e.printStackTrace(Tracing.psErr)
		}
	}
}
