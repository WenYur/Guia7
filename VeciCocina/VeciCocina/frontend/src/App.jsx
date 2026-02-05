import { BrowserRouter, Routes, Route } from "react-router-dom";
import FacturasPage from "./pages/FacturasPage";
import UsuarioPage from "./pages/UsuarioPage";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/facturas" element={<FacturasPage />} />
        <Route path="/usuarios" element={<UsuarioPage />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;