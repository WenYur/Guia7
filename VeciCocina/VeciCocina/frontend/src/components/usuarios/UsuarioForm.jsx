import { useState } from "react";
import { crearUsuario } from "../../api/usuarioApi";

export default function UsuarioForm({ onUsuarioCreada }) {
const [nombre, setNombre] = useState("");
const [apellido, setApellido] = useState("");
const [ubicacion, setUbicacion] = useState("");
const [metododepago, setMetododepago] = useState("");
const [email, setEmail] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    const usuario = {
      nombre: String(nombre),
      apellido: String(apellido),
      ubicacion: String(ubicacion),
      metododepago: String(metododepago),
      email: String(email),
      receta: null,
      transporte: null
    };

    await crearUsuario(usuario);
    setNombre("");
    setApellido("");
    setUbicacion("");
    setMetododepago("");
    setEmail("");
    onUsuarioCreada();
    };

    return (
    <form onSubmit={handleSubmit}>
        <h3>Nuevo Usuario</h3>

      <input
        type="text"
        value={nombre}
        onChange={(e) => setNombre(e.target.value)}
        placeholder="Nombre"
        required
      />
    <input
        type="text"
        value={apellido}
        onChange={(e) => setApellido(e.target.value)}
        placeholder="Apellido"
        required
      />
    <input
        type="text"
        value={ubicacion}
        onChange={(e) => setUbicacion(e.target.value)}
        placeholder="Ubicacion"
        required
      />
    <input
        type="text"
        value={metododepago}
        onChange={(e) => setMetododepago(e.target.value)}
        placeholder="Metodo de pago"
        required
      />
    <input
        type="text"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
        placeholder="Email"
        required
      />

      <button type="submit">Guardar</button>
    </form>
  );
}