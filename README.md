# Comparación de MergeSort Concurrente vs Secuencial en Java

Este proyecto analiza el impacto del paralelismo en el algoritmo de ordenamiento MergeSort, comparando su implementación **secuencial** con una versión **concurrente** en Java.

📎 **Trabajo completo (PDF)**: [`TP Final`](./TP%20Final%20Programacion%20Concurrente%20-%20Luca%20De%20La%20Via.pdf)  
🎥 **Video explicativo (<10 min)**: [YouTube](https://youtu.be/fm9HVbJc2pE)

## 📌 Objetivo

Evaluar el desempeño de MergeSort utilizando programación concurrente frente a su versión tradicional secuencial, midiendo tiempos de ejecución en diferentes volúmenes de datos.

---

## 🧪 Metodología

- Implementación de [**MergeSort secuencial**](https://github.com/lucadelavia/MergeSort-Concurrente-vs-Secuencial/blob/main/src/algoritmos/MergeSortSecuencial.java) desde cero.
- Desarrollo de [**MergeSort concurrente**](https://github.com/lucadelavia/MergeSort-Concurrente-vs-Secuencial/blob/main/src/algoritmos/MergeSortConcurrente.java) con `ForkJoinPool`.
- Umbral de 100.000 elementos para decidir si aplicar concurrencia.
- Pruebas en entornos controlados, ejecutando 10 veces cada test para promediar resultados.

---

## ⚙️ Estructura del Proyecto
src/
├── algoritmos/
│ ├── MergeSortConcurrente.java
│ ├── MergeSortSecuencial.java
│ └── MergeUtils.java
└── test/
└── MergeSortTest.java

---

## 🖥️ Requisitos

- Java JDK 21 o superior
- Sistema operativo de 64 bits

---

👨‍💻 Autor
Luca De La Via
📧 lucadelavia@gmail.com
🎓 Universidad Nacional de Lanús – 2025 – Programación Concurrente

📚 Referencias
Parallel Merge Sort with ForkJoin (HackerNoon, 2020)

FreeCodeCamp: Sorting Algorithms Explained

Codecademy: Time Complexity of MergeSort
