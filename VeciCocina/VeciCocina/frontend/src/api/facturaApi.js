import axios from "axios";

const API_URL = "http://localhost:8080/api/facturas";

export const obtenerFacturas = () =>
axios.get(API_URL);

export const crearFactura = (factura) =>
axios.post(API_URL, factura);

export const eliminarFactura = (id) =>
axios.delete(`${API_URL}/${id}`);

export const asignarInventario = (facturaId, inventarioId) =>
axios.patch(`${API_URL}/${facturaId}/inventario/${inventarioId}`);