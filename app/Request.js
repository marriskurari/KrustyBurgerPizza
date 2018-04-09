
const requestPromise = (requestString) => {
	console.log("REQUEST only works for JSON")
	console.log(requestString)
	const req = new XMLHttpRequest()
	req.open("GET",requestString, true)
	req.send()
	return new Promise((resolve, reject) => {
		req.ontimeout = () => { reject("Request timed out") }
		req.onload = () => resolve(JSON.parse(req.responseText))
		req.onerror = () => reject(req.statusText)
	})
}

export default requestPromise
