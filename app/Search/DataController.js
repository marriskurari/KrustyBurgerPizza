import Request from "./Request"

const baseString = "http://165.227.41.109:8080/database/"

const getById = (entityName, id) => {
	const requestString = `${baseString}one${entityName}?id=${id}`
	return Request(requestString)
}

const getAllByType = (pluralEntityName) => {
	let requestString = `${baseString}all${pluralEntityName}`
	return Request(requestString)
}

const createBooking = (hotelId, roomId, userId, dateFrom, dateTo, cc) => {
	let requestString = `${baseString}addBooking?`
	requestString += "hotelId=" + hotelId + "&"
	requestString += "roomId=" + roomId + "&"
	requestString += "userId=" + userId + "&"
	requestString += "isPaid=" + false + "&"
	requestString += "dateFrom=" + dateFrom + "&"
	requestString += "dateTo=" + dateTo + "&"
	requestString += "cc=" + cc
	return Request(requestString)
}

const addToUser = (userId, bookingId) => {
	let requestString = `${baseString}addBookingToUser?`
	requestString += "userId=" + userId + "&"
	requestString += "bookingId=" + bookingId + "&"
	return Request(requestString)
}

const createUser = (name, email) => {
	let requestString = `${baseString}addUser?`
	requestString += "name=" + name + "&"
	requestString += "email=" + email
	return Request(requestString)
}

const getHotelsByLocation = (lat, lng) => {
	let requestString = `${baseString}getHotelsByLocation?`
	requestString += `latitude=${lat}&`
	requestString += `longitude=${lng}`
	return Request(requestString)
}

const newUserBooking = async (name, email, hotelId, roomId, dateFrom, dateTo, cc) => {
	console.log(name)
	const userId = 	await createUser(name, email)
	console.log(userId)
	return createBooking(hotelId, roomId, userId, dateFrom, dateTo, cc)
}

const hotel = {
	getOne: (id) => getById("Hotel", id),
	getAll: () => getAllByType("Hotels"),
	getHotelsByLocation
}

const booking = {
	getOne: (id) => getById("Hotel", id),
	getAll: () => getAllByType("Bookings"),
	create: createBooking
}
const room = {
	getOne: (id) => getById("Room", id)
}

const user = {
	getOne: (id) => getById("User", id),
	getAll: () => getAllByType("Users"),
	create: createUser,
	newUserBooking: newUserBooking
}

const availability = {
	getOne: (id) => getById("Availability", id)
}

const filter = (obj, hotelId) => {
	let array = []
	for(let key in obj) {
		const review = obj[key]
		if(review.hotelId == hotelId) array.push(review)
	}
	console.log(array)
	return array
}

const review = {
	getAll: () => getAllByType("Review"),
	getFiltered: async (hotelId) => {
		const reviews = await getAllByType("Review")
		console.log(reviews)
		return filter(reviews, hotelId)
	}
}

const iconURL ={
		wifi: "https://i.imgur.com/QOLIhxO.png",
		shower: "https://i.imgur.com/y1x2e1b.png",
		breakfast: "https://i.imgur.com/PzrJ9Aw.png",
		private_bathroom: "https://i.imgur.com/SGeRQXq.jpg",
		tea: "https://i.imgur.com/nvKGfIv.png",
		coffee: "https://i.imgur.com/4edoUkq.png",
		swimming_pool: "https://i.imgur.com/9N2dMZv.png",
		accessible: "https://i.imgur.com/ax7VzhD.png",
		linen: "https://i.imgur.com/7tC9XYv.png"
}

const DCtrl = {
	hotel,
	booking,
	room,
	user,
	availability,
	review,
	iconURL
}

export default DCtrl
