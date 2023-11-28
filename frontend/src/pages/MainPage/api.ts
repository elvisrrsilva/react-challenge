import { Highlight } from "./slice";
import endpoint from "../../endpoint";

const apiBaseUrl = endpoint.url();

const createNewHighlight = async (firstName: string, lastName: string) => {
	const response = await fetch(`${apiBaseUrl}/process`, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify({ firstName, lastName }),
	});
	return await response.json() as Highlight;
}

const api = {
	createNewHighlight
}

export default api;


