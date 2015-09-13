package sample

class QuoteController {

	def scaffold = true
	// redirect example
	def index = {
		//redirect(action:home)
		//redirect(action:random)
	}
    def home = {
		render "<h2> hello Grails 2.4.2...redirect example.</h2>"
	}
	
	def random = {
		def allQuotes = Quote.list()
		def randomQuote
		if (allQuotes?.size() > 0) {
			def randomIdx = new Random().nextInt(allQuotes.size())
			randomQuote = allQuotes[randomIdx]
		} else {
			randomQuote = new Quote(author: "Anonymous",
			content: "Real Programmers Don't eat Quiche size: "+allQuotes?.size())
		}
		[ quote : randomQuote]
	}
}
