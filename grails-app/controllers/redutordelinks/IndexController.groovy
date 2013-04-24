package redutordelinks

class IndexController {

	def index = { }
	
	def linkShorterService

	def unshort = {
		//Caracteres base para conversao do link [a-zA-Z0-9] 62 caracteres
		def tab="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

		def linkInstance = linkShorterService.loadLink(params.link)
		if(linkInstance){
			//redirecionando para o link
			redirect(url:"http://"+ linkInstance.linkFull)
		}else{
			//link nao encontrado retornando http error 
			render(status:404)
		}
	}
}
