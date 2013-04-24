package redutordelinks

import grails.test.*

class LinkShorterServiceTests extends GroovyTestCase {
    def linkShorterService
   

    void testGetShortLinkForId125() {
		
		assert "cb" == linkShorterService.shortLink(125)
    }
	
	void testGetIdForLinkb() {
		def link = new Link(linkFull:"www.google.com")
		link.save()
		
		def convertedLink = linkShorterService.loadLink("b")
		
		assert 1 == convertedLink.id

	}	
}
