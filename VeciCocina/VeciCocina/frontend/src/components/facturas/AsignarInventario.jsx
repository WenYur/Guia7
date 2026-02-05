import { useState } from "react";
import { asignarInventario } from "../../api/facturaApi";

export default function AsignarInventario({ onAsignado }) {
  const [facturaId, setFacturaId] = useState("");
  const [inventarioId, setInventarioId] = useState("");

  const handleAsignar = async () => {
    if (!facturaId || !inventarioId) {
      alert("Debe ingresar ambos IDs");
      return;
    }
    try {
      await asignarInventario(
        Number(facturaId),
        Number(inventarioId)
      );
      alert("Inventario asignado correctamente ✅");
      onAsignado?.(); // refresca la lista
    } catch (error) {
      console.error("Error PATCH:", error.response?.data);
      alert("Error asignando inventario");
    }
  };

  return (
    <div>
      <input
        type="number"
        placeholder="ID Factura"
        value={facturaId}
        onChange={(e) => setFacturaId(e.target.value)}
      />

      <input
        type="number"
        placeholder="ID Inventario"
        value={inventarioId}
        onChange={(e) => setInventarioId(e.target.value)}
      />
      <button onClick={handleAsignar}>
        Asignar Inventario
      </button>
    </div>
  );
}
