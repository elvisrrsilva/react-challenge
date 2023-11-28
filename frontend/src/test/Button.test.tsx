import React from 'react';
import { render, screen } from '@testing-library/react';
import Button from '../components/Button';
import { withThemeProvider } from "./themes";


test('renders a button', () => {
	const onClick = jest.fn();
	
	render(withThemeProvider(<Button text="button2" onClick={onClick} />));
	
	const buttonElement = screen.getByText("button2")
	
	expect(onClick).not.toHaveBeenCalled();
	expect(buttonElement).not.toBeDisabled();
	expect(buttonElement).toBeInTheDocument();
});