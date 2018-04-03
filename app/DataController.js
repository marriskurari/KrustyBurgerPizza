
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

const createBooking = (hotelId, roomType, dateFrom, dateTo) => {
	let requestString = `${baseString}addBooking?`
	requestString += "hotelId=" + hotelId + "&"
	requestString += "roomType=" + roomType + "&"
	requestString += "dateFrom=" + dateFrom + "&"
	requestString += "dateTo=" + dateTo
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

const hotel = {
	getOne: (id) => getById("Hotel", id),
	getAll: () => getAllByType("Hotels")
}

const booking = {
	getOne: (id) => getById("Hotel", id),
	getAll: () => getAllByType("Hotels"),
	create: createBooking
}
const room = {
	getOne: (id) => getById("Room", id)
}

const user = {
	getOne: (id) => getById("User", id),
	getAll: () => getAllByType("Users"),
	create: createUser
}

const availability = {
	getOne: (id) => getById("Availability", id)
}

const DCtrl = {
	hotel,
	booking,
	room,
	user,
	availability
}

export default DCtrl
