package redutordelinks

class LinkController {

    static allowedMethods = [save: "POST"]

	def linkShorterService

    def create = {
        def linkInstance = new Link()
        linkInstance.properties = params
        return [linkInstance: linkInstance]
    }

    def save = {
        def linkInstance = new Link(params)
        if (linkInstance.save(flush: true)) {
			
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'link.label', default: 'Link'), linkInstance.id])}"
            redirect(action: "show", id: linkInstance.id)
        }
        else {
            render(view: "create", model: [linkInstance: linkInstance])
        }
    }

    def show = {
        def linkInstance = Link.get(params.id)
        if (!linkInstance) {
			
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'link.label', default: 'Link'), params.id])}"
            redirect(action: "list")
        }
        else {
			linkInstance.linkReduced = linkShorterService.shortLink(linkInstance.id)
			
			println linkInstance.linkReduced
			
            [linkInstance: linkInstance]
        }
    }

    
}
