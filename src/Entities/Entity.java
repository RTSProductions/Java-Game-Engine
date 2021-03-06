package Entities;

import org.lwjgl.util.vector.Vector3f;

import Models.TexturedModel;

public class Entity 
{
	private TexturedModel model;
	private Vector3f position;
	private float rotX;
	private float rotY;
	private float rotZ;
	private float scale;
	
	public Entity(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale)
	{
		this.model = model;
		this.position = position;
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
		this.scale = scale;
	}
	
	public void increasePosition(float dx, float dy, float dz)
	{
		position.x += dx;
		position.y += dy;
		position.z += dz;
	}
	public void increaseRotation(float dx, float dy, float dz)
	{
		rotX += dx;
		rotY += dy;
		rotZ += dz;
	}
	
	public void moveTo(Vector3f targetPosition)
	{
		position = targetPosition;
	}

	public TexturedModel getModel() 
	{
		return model;
	}

	public Vector3f getPosition() 
	{
		return position;
	}

	public float getRotX() 
	{
		return rotX;
	}

	public float getRotY() 
	{
		return rotY;
	}

	public float getRotZ() 
	{
		return rotZ;
	}

	public float getScale() 
	{
		return scale;
	}
	
}
