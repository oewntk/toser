package org.oewntk.ser.out

import org.junit.Test
import org.oewntk.model.LibDummyNanoModel.model1
import org.oewntk.model.SerializeJVM.serialize
import org.oewntk.model.SerializeJVM.serializeCoreModel
import org.oewntk.model.VerbTemplate
import java.io.File
import java.io.FileOutputStream

class TestsSer {

    @Test
    fun testSerDummyCoreModel() {
        val file = File("_dummy.ser")
        serializeCoreModel(model1, file)
    }

    @Test
    fun testSerVerbTemplateCoreModel() {
        val vt = VerbTemplate(1, "xxx % yyy")
        val file = File("_dummy-vb.ser")
        FileOutputStream(file).use { os ->
            serialize(os, vt)
        }
    }

    // companion object {
    //     @JvmStatic
    //     @BeforeClass
    //     fun init() {
    //     }
    // }
}