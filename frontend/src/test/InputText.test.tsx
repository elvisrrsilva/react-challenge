import React from 'react';
import {render} from '@testing-library/react';
import {withThemeProvider} from "./themes";
import InputText from "../components/InputText/";
import {getById} from "./selectors";

test('renders a input text', () => {
    const onKeyUp = jest.fn();
    const view = render(withThemeProvider(<InputText id="someid" name="somename" placeholder="some placeholder" onKeyUp={onKeyUp}/>));
    const buttonElement = getById(view.container, "someid");
    
    expect(onKeyUp).not.toHaveBeenCalled();
    expect(buttonElement).toBeInTheDocument();
});