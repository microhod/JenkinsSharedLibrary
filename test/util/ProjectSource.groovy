package util

import com.lesfurets.jenkins.unit.global.lib.SourceRetriever

class ProjectSource implements SourceRetriever {

    private def sourceDir = new File('.')

    List<URL> retrieve(String repository, String branch, String targetPath) {
        if (sourceDir.exists()) {
            return [sourceDir.toURI().toURL()]
        }
        throw new IllegalStateException("Directory $sourceDir.path does not exist")
    }
}
