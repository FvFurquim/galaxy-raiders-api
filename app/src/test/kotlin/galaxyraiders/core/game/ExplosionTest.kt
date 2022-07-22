package galaxyraiders.core.game

import galaxyraiders.core.physics.Point2D
import galaxyraiders.core.physics.Vector2D
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@DisplayName("Given a explosion")
class ExplosionTest {
  private val explosion = Explosion(
    initialPosition = Point2D(1.0, 1.0),
    initialVelocity = Vector2D(0.0, 0.0),
    radius = 1.0,
    mass = 1.0
  )

  @Test
  fun `it has a type Explosion `() {
    assertEquals("Explosion", explosion.type)
  }

  @Test
  fun `it has a symbol hat `() {
    assertEquals('*', explosion.symbol)
  }

  @Test
  fun `it shows the type Explosion when converted to String `() {
    assertTrue(explosion.toString().contains("Explosion"))
  }

  @Test
  fun `it reduces by one the time`() {
    val initTime = explosion.time
    explosion.reduceTime()

    assertEquals(initTime - 1, explosion.time)
  }

  @Test
  fun `it returns the isTriggered as false when time = 0 after reduceTime()`() {
    explosion.time = 1
    explosion.reduceTime()

    assertFalse(explosion.isTriggered)
  }
}
