package redutordelinks

class Link {
	
	String linkFull
	String linkReduced
	
	static transients = ['linkReduced']

    static constraints = {
		linkFull(blank:false)
    }
	
}
