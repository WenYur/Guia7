import { useState } from "react";
import { asignarReceta } from "../../api/usuarioApi";

export default function AsignarReceta({ onAsignado }) {
  const [usuarioId, setUsuarioId] = useState("");
  const [recetaId, setRecetaId] = useState("");

  const handleAsignar = async () => {
    if (!usuarioId || !recetaId) {
      alert("Debe ingresar ambos IDs");
      return;
    }
    try {
      await asignarReceta(
        Number(usuarioId),
        Number(recetaId)
      );
      alert("Receta asignada correctamente ✅");
      onAsignado?.(); // refresca la lista
    } catch (error) {
      console.error("Error PATCH:", error.response?.data);
      alert("Error asignando receta");
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
        placeholder="ID Receta"
        value={recetaId}
        onChange={(e) => setRecetaId(e.target.value)}
      />
      <button onClick={handleAsignar}>
        Asignar Receta
      </button>
    </div>
  );
}
