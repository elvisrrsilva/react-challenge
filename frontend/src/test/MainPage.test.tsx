import React from 'react';
import {render} from '@testing-library/react';
import {withThemeProvider} from "./themes";
import MainPage from "../pages/MainPage";
import {getById} from "./selectors";
import {withProvider} from "./states";


test('renders a breakify page', () => {
    const view = render(withProvider(withThemeProvider(<MainPage/>)));
    const firstNameElement = getById(view.container, "firstName");
    const lastNameElement = getById(view.container, "lastName");
    const buttonElement = getById(view.container, "breakify");
    
    expect(firstNameElement).toBeInTheDocument();
    expect(lastNameElement).toBeInTheDocument();
    expect(buttonElement).toBeInTheDocument();
});