import { ThemeProvider } from "styled-components";
import light from "../styles/theme";

export function withThemeProvider(children: React.ReactNode) {
	return (
		<ThemeProvider theme={light}>
			{children}
		</ThemeProvider>
	)
}