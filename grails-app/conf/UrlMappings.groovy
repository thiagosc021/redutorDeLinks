class UrlMappings {

	static mappings = {
		"/app/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		
		"/$link?" {
			controller = "index"
			action = "unshort"
		}

		"/"(controller:"/index")
		"500"(view:'/error')
	}
}
