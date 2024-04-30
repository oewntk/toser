/*
 * Copyright (c) 2021-2024. Bernard Bou.
 */
package org.oewntk.ser.out

import org.oewntk.model.Model
import org.oewntk.model.Serialize.serializeCoreModel
import java.io.File
import java.io.IOException
import java.util.function.Consumer

/**
 * Main class that serializes the model
 *
 * @property file output file
 * @author Bernard Bou
 */
class ModelConsumer(private val file: File) : Consumer<Model> {

    override fun accept(model: Model) {
        Tracing.psInfo.printf("[Model] %s%n", model.sources.contentToString())
        try {
            serializeCoreModel(model, file)
        } catch (e: IOException) {
            e.printStackTrace(Tracing.psErr)
        }
    }
}
