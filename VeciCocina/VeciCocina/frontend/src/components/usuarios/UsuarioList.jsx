import { useEffect, useState } from "react";
import { obtenerUsuarios, eliminarUsuario } from "../../api/usuarioApi";

export default function UsuarioList({ refrescar }) {
  const [usuarios, setUsuarios] = useState([]);

  const cargarUsuario = async () => {
    const res = await obtenerUsuarios();
    setUsuarios(res.data);
  };

  useEffect(() => {
    cargarUsuario();
  }, [refrescar]);

  const borrar = async (id) => {
    await eliminarUsuario(id);
    cargarUsuario();
  };

  return (
    <div>
      <h3>Usuarios</h3>

      <ul>
        {usuarios.map((u) => (
          <li key={u.id}>
            <strong>ID:</strong> {u.id_Usuario} | 
            <strong> Nombre:</strong> {u.nombre}
            <strong> Apellido:</strong> {u.apellido}
            <strong> Ubicacion:</strong> {u.ubicacion}
            <strong> Metodo de pago:</strong> {u.metodo_de_Pago}
            <strong> Email:</strong> {u.email}
            <strong>Receta:</strong>{" "}
            {u.receta ? u.receta.id_Receta : "No asignado"}
            <strong>Transporte:</strong>{" "}
            {u.transporte ? u.transporte.id_transporte : "No asignado"}

            <button onClick={() => borrar(u.id_Usuario)}>❌</button>
          </li>
        ))}
      </ul>
           
    </div>
  );
}