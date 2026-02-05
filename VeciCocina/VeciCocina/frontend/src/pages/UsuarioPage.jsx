import { useState } from "react";
import UsuarioForm from "../components/usuarios/UsuarioForm";
import UsuarioList from "../components/usuarios/UsuarioList";
import AsignarReceta from "../components/usuarios/AsignarReceta";
import AsignarTransporte from "../components/usuarios/AsignarTransporte";


export default function UsuarioPage() {
  const [refrescar, setRefrescar] = useState(false);
    const recargarUsuarios = async () => {
    setRefrescar((prev) => !prev);
    };
  
return (
    <div>
      <h2>Gestión de Usuarios</h2>
      <UsuarioForm onUsuarioCreada={() => setRefrescar(!refrescar)} />
      <AsignarReceta onAsignado={recargarUsuarios} />
      <AsignarTransporte onAsignado={recargarUsuarios} />
      <UsuarioList refrescar={refrescar} />
    </div>
  );
}