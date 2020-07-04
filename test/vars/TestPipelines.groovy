package vars

import org.junit.Test
import org.junit.Before
import com.lesfurets.jenkins.unit.BasePipelineTest
import static com.lesfurets.jenkins.unit.global.lib.LibraryConfiguration.library
import util.ProjectSource

class TestPipelines extends BasePipelineTest {

    def script

    @Override
    @Before
    void setUp() throws Exception {
        scriptRoots += 'test/jenkins/'
        super.setUp()
        helper.init()
        helper.registerSharedLibrary(
            library()
                .name('test')
                .retriever(new ProjectSource())
                .targetPath('is/not/necessary')
                .defaultVersion("fakes")
                .allowOverride(true)
                .implicit(true)
                .build()
        )
        script = loadScript('test.pipeline')
    }

    @Test
    void testPasses() {
        script.passes()
    }

    @Test
    void testFails() {
        script.fails()
    }
}