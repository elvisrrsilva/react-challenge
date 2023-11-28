import React from "react";
import { Container } from "./style";
import Button from "../../components/Button";
import InputText from "../../components/InputText";
import { useAppDispatch } from "../../state/hooks/useAppDispatch";
import { createNewHighlight } from "./slice";
import HighlightedPage from "../HighlightedPage";
import { AlertBox } from "../../components/AlertBox";

type BreakifyForm = {
	firstName: string;
	lastName: string;
}

const MainPage: React.FC = () => {

	const dispatch = useAppDispatch();

	const [form, setForm] = React.useState<BreakifyForm>({
		firstName: "",
		lastName: ""
	});

	const handleOnKeyUp = (name: string, value: string, key: string) => {

		if (key === "Enter") {
			highlight();
			return;
		}

		setForm({
			...form,
			[name]: value
		});
	}

	const highlight = async () => {

		const { firstName, lastName } = form;
		
		if (!firstName) {
			await AlertBox.error("First Name requied", "Please fill First Name!");
			return;
		}
		
		if (!lastName) {
			await AlertBox.error("Last Name requied", "Please fill Last Name!");
			return;
		}
		dispatch(createNewHighlight({ firstName, lastName }));
	}

	return (
		<Container>
			<div>
				<div>
					<HighlightedPage size="large" field="firstName" />
					<HighlightedPage size="small" field="lastName" />
				</div>
				<form className="form" noValidate={true}>
					<div className="horizontal">
						<div className="form-field">
							<label htmlFor="firstName">First Name</label>
							<InputText id="firstName" name="firstName" placeholder="Enter your first name"
								onKeyUp={handleOnKeyUp} />
						</div>
						<div className="form-field">
							<label htmlFor="lastName">Last Name</label>
							<InputText id="lastName" name="lastName" placeholder="Enter your last name"
								onKeyUp={handleOnKeyUp} />
						</div>
					</div>
					<div>
						<Button id="breakify" className="w-100" text="Breakify" onClick={highlight} />
					</div>
				</form>
			</div>
		</Container>
	)
}

export default MainPage;