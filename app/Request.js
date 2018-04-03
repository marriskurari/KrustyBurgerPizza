
const requestPromise = (requestString) => {
	const req = new XMLHttpRequest()
	req.open("GET",requestString, true)
	req.send()
	return new Promise((resolve, reject) => {
		req.ontimeout = () => { reject("Request timed out") }
		req.onreadystatechange = () => {
			if(req.status >= 500) reject("Internal server error for" + requestString)
			if(req.status >= 400) reject("Item not found for" + requestString)
			if(req.status >= 200 && req.status < 300) resolve(req.responseText)
		}
	})
}

export default requestPromise
