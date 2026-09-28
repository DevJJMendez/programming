# store()
El método store() en un controlador de Laravel se encarga de almacenar un nuevo recurso en la base de datos. 

## Características de un método store() bien diseñado
* Validación estricta: Usar Form Requests para validar la entrada.
* Uso de transacciones: Asegurar consistencia en la base de datos.
* Manejo de errores: Capturar excepciones y devolver respuestas adecuadas.
* Estructura clara: Separar responsabilidades (validación, lógica de negocio, persistencia).
* Optimización: Evitar consultas innecesarias y usar relaciones adecuadamente.

## Implementación de un método store() optimizado
```php
<?php

namespace App\Http\Controllers;

use App\Http\Requests\StoreUserRequest;
use App\Http\Resources\UserResource;
use App\Models\User;
use Illuminate\Http\JsonResponse;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;
use Exception;

class UserController extends Controller
{
    /**
     * Almacena un nuevo usuario en la base de datos.
     */
    public function store(StoreUserRequest $request): JsonResponse
    {
        try {
            DB::beginTransaction(); // Inicia una transacción

            // Crear usuario
            $user = User::create([
                'name' => $request->name,
                'email' => $request->email,
                'password' => Hash::make($request->password), // Encriptar contraseña
            ]);

            DB::commit(); // Confirmar transacción

            return response()->json([
                'message' => 'Usuario creado exitosamente',
                'user' => new UserResource($user)
            ], 201);

        } catch (Exception $e) {
            DB::rollBack(); // Revertir cambios si hay error
            return response()->json([
                'message' => 'Error al crear usuario',
                'error' => $e->getMessage()
            ], 500);
        }
    }
}
```