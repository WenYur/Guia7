import { useState } from "react";
import { asignarTransporte } from "../../api/usuarioApi";

export default function AsignarTransporte({ onAsignado }) {
  const [usuarioId, setUsuarioId] = useState("");
  const [transporteId, setTransporteId] = useState("");

  const handleAsignar = async () => {
    if (!usuarioId || !transporteId) {
      alert("Debe ingresar ambos IDs");
      return;
    }
    try {
      await asignarTransporte(
        Number(usuarioId),
        Number(transporteId)
      );
      alert("Transporte asignado correctamente ✅");
      onAsignado?.(); // refresca la lista
    } catch (error) {
      console.error("Error PATCH:", error.response?.data);
      alert("Error asignando transporte");
    }
  };

  return (
    <div>
      <input
        type="number"
        placeholder="ID Usuario"
        value={usuarioId}
        onChange={(e) => setUsuarioId(e.target.value)}
      />

      <input
        type="number"
        placeholder="ID Transporte"
        value={transporteId}
        onChange={(e) => setTransporteId(e.target.value)}
      />
      <button onClick={handleAsignar}>
        Asignar Transporte
      </button>
    </div>
  );
}
