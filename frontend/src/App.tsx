import React, { lazy, Suspense } from 'react';
import { Route, Routes } from "react-router";

const MainPage = lazy(() => import('./pages/MainPage'));

const App: React.FC = () => {
	return (
		<Suspense fallback={<div>Loading...</div>}>
			<Routes>
				<Route path="/" element={<MainPage />} />
			</Routes>
		</Suspense>
	);
};

export default App;
